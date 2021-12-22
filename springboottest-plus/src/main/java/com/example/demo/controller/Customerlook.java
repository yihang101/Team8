package com.example.demo.controller;

import com.example.demo.Mapper.CustMapper;
import com.example.demo.entiy.Customer;
import com.example.demo.entiy.CustomerZC;
import com.example.demo.entiy.HisGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class Customerlook {

    @Autowired
    @Resource
    CustMapper custMapper;

    @GetMapping("/get/{custname}")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List<HisGood> getCustomer(@PathVariable("custname")String custname){
        System.out.println(custname);
        System.out.println(custMapper.getall2(custname));
        return custMapper.getall2(custname);
    }
    @GetMapping("/zcget")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List<CustomerZC> getZCCustomer(){
        System.out.println(custMapper.getall3());
        return custMapper.getall3();
    }

}
