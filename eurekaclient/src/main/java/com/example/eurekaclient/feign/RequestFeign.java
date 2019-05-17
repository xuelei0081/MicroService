package com.example.eurekaclient.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="eureka-producer")
public interface RequestFeign {

   @RequestMapping(value = "/getJsonp")
    public String getJsonp();
}
