package com.example.demo.controller;

import com.example.demo.Mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")

public class LoginController {
    @Autowired

    @Resource
    LoginMapper lgm;
    @PutMapping("change/{pwd}")
    public String changepwd(@PathVariable("pwd") String pwd){
        lgm.change(pwd);
        return "success";
    }
}
