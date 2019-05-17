package com.example.eurekaproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonpRequestController {

    @RequestMapping("/getJsonp")
    public String getJsonp(){

        Map<String,String> map = new HashMap<>();
        map.put("name","使用jsonp跨域异步请求");
        map.put("flag","成功调用");
        return  map.toString();
    }
    @RequestMapping("/getJsonpTrue")
    @ResponseBody
    public String getJsonpTrue(@RequestParam String callback){
        String result =  "{'ret':'true'}";
        //加上返回参数
        result=callback+"("+result+")";
        return result;
    }
}
