package com.kedun.provider2.controller;

import com.kedun.provider2.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
@RequestMapping(value = "/user")
@RestController
public class userController {
    @Autowired
    RestTemplate restTemplate;

    //    public List<User> userList = new ArrayList();
//    public HashMap<Integer, User> userMap ;
    @HystrixCommand(fallbackMethod = "s")
    @RequestMapping(value = "/getUserInfo")
    public String getUserAndOrder() {
        User user = new User(1, "张三", "男", 18);
        String orderNo = restTemplate.getForObject("http://orderService/getOrder" , String.class);
        String result = "用户信息为：" + user.toString() + "/r/n" + "订单号为:" + orderNo;
        return result;

    }

    @PostConstruct
    public void initUserInfo() {
//        userMap = new ConcurrentHashMap<Integer, User>();
//        User user = new User(1, "张三", "男", 18);
//        User user1 = new User(2, "李四", "女", 20);
//        User user2 = new User(3, "王五", "男", 10);
//        userList.add(user);
//        userList.add(user1);
//        userList.add(user2);
    }
    public String s () {
        return "启用了熔断器。。。。。。";
    }

}
