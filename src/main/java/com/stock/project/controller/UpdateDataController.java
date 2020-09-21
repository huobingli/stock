package com.stock.project.controller;


import com.stock.project.dao.UpdateData;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 更新数据库中
public class UpdateDataController {
    @Autowired
    private UpdateData updateData;

    @RequestMapping("ExecuteUpdateData")
    //@RequestBody
    public ResultVo ExecuteUpdateData() {
        Integer result = updateData.UpdateData();
        String strRet = "已更新" + result + " %d条数据";
        return ResultVo.success(strRet);
    }

    public static class UpdateDapanController {
    }
}
