package com.stock.project.controller;

import com.stock.project.dao.SxxData;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SxxDataController {
    @Autowired
    private SxxData sxxData;

    @RequestMapping("UpdateSxxData")
    //@RequestBody
    public ResultVo UpdateSxxData() {
        try {
//            解析文件

//            List<SxxDataEntity> arrayList = new ArrayList<>();
//
////            for (int i = 0; i < arrayData.size(); i++) {
////                SxxDataEntity sxxdata = new SxxDataEntity();
////                arrayList.add(sxxdata);
////            }
//
//            sxxData.InsertSxxData(arrayList);
            return ResultVo.success("插入成功");

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(-1, "抛出异常");
        }
    }

    @RequestMapping("SelectSxxData")
    //@RequestBody
    public ResultVo SelectSxxData() {
        try {
            return ResultVo.success("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(-1, "抛出异常");
        }
    }
}
