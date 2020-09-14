package com.stock.project.controller;

import com.stock.project.dao.ResultEntity;
import com.stock.project.dao.SelectStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class SelectController {
    @Autowired
    private SelectStock selectStock;

    @RequestMapping("SelectStock")
    public List<ResultEntity> Select(@RequestParam("name") String name) {
//        ResultEntity result = selectStock.Select(name);
        selectStock.Select(name);
        ResultEntity result = new ResultEntity();
        return Arrays.asList(result);
    }
}
