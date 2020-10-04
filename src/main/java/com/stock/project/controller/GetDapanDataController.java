package com.stock.project.controller;

import com.stock.project.dao.DapanLimitUpDownEntity;
import com.stock.project.dao.GetDapanData;
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
            List<DapanLimitUpDownEntity> result = getDapanData.SelectList();

            for ( int i = 0; i < result.size(); i++) {
                DapanLimitUpDownEntity data = result.get(i);
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");

                long lTime = Long.parseLong(data.getTime());
                Date date = new Date(lTime);
                data.setTime(formatter.format(date));
            }
            return ResultVo.success(result);
        } catch (Exception e) {

            return ResultVo.error(-1, "查询错误");
        }

    }

}
