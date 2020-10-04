package com.stock.project.dao;

import java.util.List;

public interface GetDapanData {
    // 大盘涨跌停数据
    List<DapanLimitUpDownEntity> SelectDapanLUDInfoList();

    // 大盘涨跌数据
    List<DapanRiseInfoEntity> SelectDapanRiseInfoList();
}
