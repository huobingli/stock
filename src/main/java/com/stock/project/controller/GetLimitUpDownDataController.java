package com.stock.project.controller;


import com.stock.project.dao.DayLimitDataEntity;
import com.stock.project.dao.OperateDayLimitData;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
*   用于获取每日涨停数据 首板以及连板数据
*
*
*
*
* */
public class GetLimitUpDownDataController {

    @Autowired
    OperateDayLimitData operateDayLimitData;

    //@RequestMapping(value = "/Query/{id}/{name}/{address}"

    public ResultVo GetLimitData(@RequestParam("limitday") Integer limitday) {
        List<DayLimitDataEntity> result;
        result = operateDayLimitData.SelectList(limitday);
        return ResultVo.success(result);
    }

}
