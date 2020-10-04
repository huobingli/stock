package com.stock.project.controller;

import com.stock.project.dao.DapanLimitUpDownEntity;
import com.stock.project.dao.DapanRiseInfoEntity;
import com.stock.project.dao.GetDapanData;
import com.stock.project.dao.RetDapanLimitUpDownEntity;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class GetDapanDataController {
    @Autowired
    GetDapanData getDapanData;

    @RequestMapping("GetDapanDayData")
    public ResultVo GetDapanDayData() {
        try{
            List<DapanLimitUpDownEntity> result = getDapanData.SelectDapanLUDInfoList();

            int max = 0;
            int min = 0;

            for ( int i = 0; i < result.size(); i++) {
                DapanLimitUpDownEntity data = result.get(i);
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");

                long lTime = Long.parseLong(data.getTime());
                Date date = new Date(lTime);
                data.setTime(formatter.format(date));

                if(max == 0) {
                    max = data.getZt_num();
                }
                else {
                    max = max < data.getZt_num() ? data.getZt_num() : max;
                }

                if (min == 0) {
                    min = data.getDt_num();
                }
                else {
                    min = min < data.getDt_num() ? min : data.getDt_num();
                }
            }

            // 设置返回
            RetDapanLimitUpDownEntity ret = new RetDapanLimitUpDownEntity();
            ret.setMax(max);
            ret.setList(result);
            return ResultVo.success(ret);
        } catch (Exception e) {
            return ResultVo.error(-1, "查询错误");
        }
    }

    @RequestMapping("GetDapanRiseData")
    public ResultVo GetDapanRiseData() {
        try{
            List<DapanRiseInfoEntity> result = getDapanData.SelectDapanRiseInfoList();

            int max = 0;
            int min = 0;

            for ( int i = 0; i < result.size(); i++) {
                DapanRiseInfoEntity data = result.get(i);
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");

                long lTime = Long.parseLong(data.getTime());
                Date date = new Date(lTime);
                data.setTime(formatter.format(date));

                if(max == 0) {
                    max = data.getZf_zero_num();
                }
                else {
                    max = max < data.getZf_zero_num() ? data.getZf_zero_num() : max;
                }

                if (min == 0) {
                    min = data.getDf_zero_num();
                }
                else {
                    min = min < data.getDf_zero_num() ? min : data.getDf_zero_num();
                }
            }

            // 设置返回
            RetDapanLimitUpDownEntity ret = new RetDapanLimitUpDownEntity();
            ret.setMax(max < min ? min : max);
            ret.setList(result);
            return ResultVo.success(ret);
        } catch (Exception e) {
            return ResultVo.error(-1, "查询错误");
        }
    }
}
