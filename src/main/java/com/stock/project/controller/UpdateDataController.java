package com.stock.project.controller;


import com.stock.project.dao.ResultEntity;
import com.stock.project.dao.UpdateData;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 更新数据库中
public class UpdateDataController {
    @Autowired
    private UpdateData updateData;

    @RequestMapping("/ExecuteUpdateData")
    @RequestBody
    public ResultVo ExecuteUpdateData(@RequestParam("name") String name) {
        ResultEntity result = selectStock.Select(name);
        return ResultVo.success(result);
    }

}
