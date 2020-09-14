package com.stock.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class testlogin {

    @RequestMapping("hello")
    @ResponseBody
    public String Hello() {
        return "hello";
    }

     
}
