package com.stock.project.controller;

import com.stock.project.dao.HillHouseEntity;
import com.stock.project.dao.HillHouseStock;
import com.stock.project.dao.ResultEntity;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HillHouseController {

    @Autowired
    private HillHouseStock hillHouseStock;

    @RequestMapping("SelectHillHouse")
    @ResponseBody
    public ResultVo Select(@RequestParam("name") String name) {
        HillHouseEntity result = hillHouseStock.Select(name);
        return ResultVo.success(result);
    }

    @RequestMapping("SelectHillHouseList")
    @ResponseBody
    public ResultVo SelectList(@RequestParam("name") String name) {
        List<HillHouseEntity> result = hillHouseStock.SelectList(name);
        return ResultVo.success(result);
    }
}
