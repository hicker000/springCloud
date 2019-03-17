package com.kedun.provider.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class orderController {

    @RequestMapping(value = "/getOrder")
    public String getOrderNo() {
        String o = UUID.randomUUID().toString();
        return "获取的订单号为:"+o;
    }

}
