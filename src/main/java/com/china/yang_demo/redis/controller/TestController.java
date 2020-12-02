package com.china.yang_demo.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/test/{id}")
    public void test(@PathVariable String id){
        System.out.println("test~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:"+id);
        redisTemplate.opsForValue().set("test","这是一个样本数据");
        Object test = redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }
}
