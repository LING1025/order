package com.funtl.myshop.plus.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demo")
public class ViewControlller {
    @GetMapping("index")
    public String index(){
        return "成功啦啦啦啦啦啦";
    }
}
