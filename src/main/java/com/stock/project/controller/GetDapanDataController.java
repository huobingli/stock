package com.stock.project.controller;

import com.stock.project.dao.DapanLimitUpDownEntity;
import com.stock.project.dao.GetDapanData;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

            return ResultVo.success(result);
        } catch (Exception e) {

            return ResultVo.error(-1, "查询错误");
        }

    }

}
