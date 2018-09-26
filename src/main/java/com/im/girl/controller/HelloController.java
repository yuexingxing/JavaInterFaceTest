package com.im.girl.controller;

import com.im.girl.GirlProterties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;

@RestController
@RequestMapping("/demo")
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private int age;

    @Autowired
    private GirlProterties girlProterties;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String hello() {

        return girlProterties.getCupSize();
    }

    //GET带参数请求
    @RequestMapping(value = {"/add/{id}"}, method = RequestMethod.GET)
    public String add(@PathVariable("id") String id) {

        return id;
    }

    //POST带参数请求
    @RequestMapping(value = {"/add1"}, method = RequestMethod.POST)
    public String add1(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {

        return "id = " + id;
    }
}
