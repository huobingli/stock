package com.stock.project.controller;

import com.stock.project.dao.ResultEntity;
import com.stock.project.dao.SelectStock;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/")
public class SelectController {
    @Autowired
    private SelectStock selectStock;

    @RequestMapping("SelectStock")
    @ResponseBody
    public ResultVo Select(@RequestParam("name") String name) {
        ResultEntity result = selectStock.Select(name);
        return ResultVo.success(result);
    }

    @RequestMapping("SelectStockList")
    @ResponseBody
    public ResultVo SelectList(@RequestParam("name") String name) {
        List<ResultEntity> result = selectStock.SelectList(name);
        return ResultVo.success(result);
    }
}
