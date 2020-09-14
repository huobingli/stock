package com.stock.project.controller;

import com.stock.project.dao.InsertStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class InsertController {
    @Autowired
    private InsertStock insertStock;

    @RequestMapping("InsertStock")
    public String Insert(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("industry") String industry) {
        insertStock.Insert(code, name, industry);
        return "Insert Success";
    }
}
