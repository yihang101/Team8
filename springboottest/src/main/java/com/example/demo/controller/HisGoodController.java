package com.example.demo.controller;

import com.example.demo.mapper.CustMapper;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.mapper.HisGoodMapper;
import com.example.demo.entiy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hisg")
public class HisGoodController {
    @Autowired
    @Resource//调用接口类
            CustMapper customer;
    @Resource//调用接口类
            GoodMapper goodMapper;
    @Resource//调用接口类
            HisGoodMapper hisGoodMapper;
    @Resource
    HisGoodMapper hisgm;
    @GetMapping("/get")
    public List<HisGood> getall(){
        return hisgm.getall();
    }

    @PutMapping("/sell/{name}")
    public String sell(@PathVariable("name") String name){
        hisgm.sell(name);
        return "success";
    }

    @PostMapping("/find")
    public int find2(@RequestBody Namenaem namenaem){

        int str = 0;
        CustomerZC cust =null;
        cust = customer.find(namenaem.getCustname());
        Good good1 = null;
        good1 = goodMapper.find2(namenaem.goodname);
        System.out.println(good1);
        if(good1==null) {
            str=1;           //查找good是否为空，为空返回1
            System.out.println(1);
        }else if(good1.getNumber()<=namenaem.getNumber()){
            str=2;           //剩余数量少于库存
            System.out.println(2);
        }else {
        System.out.println(namenaem.getGoodname()+namenaem.getCustname());
        good1 =  goodMapper.find2(namenaem.getGoodname());
        HisGood hisg = new HisGood();
        hisg.setInformation(good1.getInformation());
        hisg.setName(good1.getName());
        hisg.setPrice(good1.getPrice());
        hisg.setUrl(good1.getUrl());
        hisg.setCustname(namenaem.getCustname());
        hisg.setAddress(cust.getAddress());
        hisg.setNumber(namenaem.getNumber());
            System.out.println(hisg);
            hisGoodMapper.save(hisg);
            int number = good1.getNumber()-namenaem.getNumber();
            System.out.println(number);
            Good good2 = new Good();
           good2.setNumber(number);
           good2.setName(namenaem.getGoodname());
            goodMapper.upgood1(good2);

       /** goodMapper.delete(namenaem.getGoodname());**/
        }
        return str;
    }
}
