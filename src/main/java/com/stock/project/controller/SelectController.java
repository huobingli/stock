package com.stock.project.controller;

import com.stock.project.dao.ResultEntity;
import com.stock.project.dao.SelectStock;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
//@CrossOrigin(allowedHeaders = {"*"}, allowCredentials = "true", origins = "http://localhost:8081")
//@RequestMapping("/")
//@CrossOrigin(origins = "*",maxAge = 3600)
//@ConditionalOnProperty(name="management.endpoints.web.cors.enable", havingValue="true")
public class SelectController {
    @Autowired
    private SelectStock selectStock;

    @RequestMapping("SelectStock")
    @ResponseBody
    public ResultVo Select(@RequestParam("name") String name) {
        ResultEntity result = selectStock.Select(name);
        return ResultVo.success(result);
    }

    @RequestMapping("api/{stockCode}")
    @ResponseBody
    public ResultVo stockCode(@PathVariable String stockCode, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResultVo.success(stockCode);
    }

    @RequestMapping("SelectStockList")
    @ResponseBody
    public ResultVo SelectList(@RequestParam("name") String name) {
        List<ResultEntity> result = selectStock.SelectList(name);
        return ResultVo.success(result);
    }
}
