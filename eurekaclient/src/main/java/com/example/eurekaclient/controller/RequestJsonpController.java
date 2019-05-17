package com.example.eurekaclient.controller;

import com.example.eurekaclient.feign.RequestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestJsonpController {

    @Autowired
    RequestFeign requestFeign;

    @RequestMapping("/getJsonp")
    @ResponseBody
    public String getJsonp(){
        return requestFeign.getJsonp();
    }
}
