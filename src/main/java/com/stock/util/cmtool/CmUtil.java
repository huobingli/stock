package com.stock.util.cmtool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;


import java.text.DecimalFormat;
import java.util.*;

@Slf4j
public class CmUtil {
    private long circulationAmount;
    private double closePrice;
    private List<CmKline> kList;
    private CmConfig cmConfig;


    private DecimalFormat df = new DecimalFormat("######0.00");


    public Cm2(List<CmKline> kList, long circulationAmount, CmConfig cmConfig) {
        log.info("配置信息：" + cmConfig);
        Assert.notEmpty(kList, "k线数据列表不能为空");
        this.circulationAmount = circulationAmount;
        this.cmConfig = cmConfig;
        long sum = 0;
        for (int i = kList.size() - 1; i >= 0; i--) {
            CmKline k = kList.get(i);
            if (i == kList.size() - 1) {
                this.closePrice = k.getClose();
            }
            sum += k.getVolume();
            if (sum >= (this.circulationAmount * cmConfig.getX())) {
                this.kList = kList.subList(i, kList.size());
                // ***
                log.info("筛选总股本K线数据，数量：" + kList.size() + "===>" + this.kList.size() + ",总成交量：" + sum +                        ",最后一个K:" + k);
                break;
            }
            // 到这，说明K线数量不足总股本的x倍，此时取全部KList
            this.kList = kList;
        }
    }


    /**
     * 筹码计算核心算法
     * 筹码数据反映的是 股价对应的筹码数量
     * 这个算法生成的筹码是基于K线最高价、最低价、成交量模拟的
     *
     * @return 筹码数据，
     */
    public Map<Double, Long> calcChip() {        TreeMap<Double, Long> chips = new TreeMap<>();
        // 衰减因数；
        double pct = 1.0;        // 这里倒序遍历，因为行情获取的K线数据 日期是从小到大的，取K线数量时从最新日期开始取
        for (int i = kList.size() - 1; i >= 0; i--) {
            K k = kList.get(i);
            double high = k.getHigh();
            double low = k.getLow();
            long volume = k.getVolume();
            // 每遍历一个K柱，衰减因数都减小
            pct *= 1.0 - (volume * 1.0 / this.circulationAmount * 2);            Assert.isTrue(high >= low, "最高价不能小于最低价");
            if (high == low) {
                chips.put(low, volume);
            } else {
                // 计算三角形总面积 = 底*高/2
                double area = (high - low) * ((high - low) / 2.0 * cmConfig.getTan()) / 2.0;                // 三角形底部中点
                double mid = (high + low) / 2.0;                // 在底部，将三角形等间隔分成小长方形
                for (double tempLow = low; tempLow <= high; tempLow += cmConfig.getSep()) {                    // 计算每小长方形的高度，这个高度和三角形的底角大小有关
                    double h;                    if (tempLow <= mid) {
                        h = (tempLow + cmConfig.getSep() - low) * cmConfig.getTan();
                    } else {
                        h = ((mid - (tempLow - mid)) - low) * cmConfig.getTan();
                    }
                    // 计算小长方形所占三角形面积的比例，乘以总成交量，得到该价格对应的股本数量
                    long blockAmount = (long) (cmConfig.getSep() * h / area * volume);                    // 计算出的数量*衰减因数
                    blockAmount *= pct;                    // 修正精度 保留2位小数
                    tempLow = Double.parseDouble(df.format(tempLow));                    if (chips.containsKey(tempLow)) {
                        blockAmount += chips.get(tempLow);
                    }
                    chips.put(tempLow, blockAmount);
                }
            }
        }
        // 按step间隔取数
        int step = chips.size() / cmConfig.getChipCount();        Iterator<Map.Entry<Double, Long>> iterator = chips.entrySet().iterator();
        for (int index = 0; iterator.hasNext(); index++) {
            iterator.next();
            if (index % step != 0) {
                iterator.remove();
            }
        }
        return chips;
    }


    /**
     * 计算获利指标，成本指标，集中度
     */
    public Map<String, Double> calcIndex(Map<Double, Long> chipMap) {        long currentTotalVolume = 0;
        // 筹码价格从低到高
        // pct5: 筹码前5%对应的价格；pct95: 筹码前95%对应的价格；
        // pct15: 筹码前15%对应的价格；pct85: 筹码前85%对应的价格；
        // 90%成本：pct5 ~ pct95; 70%成本：pct15 ~ pc85
        double pct5 = 0.0, pct95 = 0.0, pct15 = 0.0, pct85 = 0.0;        // closeWinRate：收盘获利；avgCost：平均成本
        double closeWinRate = 0.0, avgCost = 0.0;        // 筹码中的总成交量
        long totalVolume = chipMap.entrySet().stream().mapToLong(Map.Entry::getValue).sum();
        for (Map.Entry<Double, Long> entry : chipMap.entrySet()) {
            currentTotalVolume += entry.getValue();
            double rate = currentTotalVolume * 1.0 / totalVolume;
            if (closeWinRate == 0.0 && entry.getKey() >= this.closePrice) {
                closeWinRate = rate;
            }
            if (avgCost == 0.0 && currentTotalVolume >= totalVolume / 2.0) {
                avgCost = entry.getKey();
            }
            if (pct95 == 0.0 && rate >= 0.95) {
                pct95 = entry.getKey();
            } else if (pct85 == 0.0 && rate >= 0.85) {
                pct85 = entry.getKey();
            } else if (pct15 == 0.0 && rate >= 0.15) {
                pct15 = entry.getKey();
            } else if (pct5 == 0.0 && rate >= 0.05) {
                pct5 = entry.getKey();
            }
        }
        // 90%集中度
        double focus90 = (pct95 - pct5) / (pct95 + pct5);        // 70%集中度
        double focus70 = (pct85 - pct15) / (pct85 + pct15);
        // 如果到此closeWinRate：收盘获利 为0, 则置为1
        closeWinRate = closeWinRate == 0.0 ? 1 : closeWinRate;
        HashMap<String, Double> indexMap = new HashMap<>(8);
        indexMap.put("pct5", Double.valueOf(df.format(pct5)));
        indexMap.put("pct95", Double.valueOf(df.format(pct95)));
        indexMap.put("pct15", Double.valueOf(df.format(pct15)));
        indexMap.put("pct85", Double.valueOf(df.format(pct85)));
        indexMap.put("closeWinRate", Double.valueOf(df.format(closeWinRate * 100)));
        indexMap.put("avgCost", Double.valueOf(df.format(avgCost)));
        indexMap.put("focus90", Double.valueOf(df.format(focus90 * 100)));
        indexMap.put("focus70", Double.valueOf(df.format(focus70 * 100)));


        return indexMap;
    }


    public long getCirculationAmount() {
        return circulationAmount;
    }


    public void setCirculationAmount(long circulationAmount) {
        this.circulationAmount = circulationAmount;
    }


    public List<CmKline> getkList() {
        return kList;
    }


    public void setkList(List<CmKline> kList) {
        this.kList = kList;
    }


    public CmConfig getCmConfig() {
        return cmConfig;
    }


    public void setCmConfig(CmConfig cmConfig) {
        this.cmConfig = cmConfig;
    }
}
