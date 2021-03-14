package com.dpccours.system.controller;

import com.dpccours.system.service.TestServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//RestController返回json字符串,controller返回页面
public class TestController {

    @Resource
    private TestServer testServer;

    @RequestMapping("/test")
    public List test(){
        return testServer.list();
    }

}
