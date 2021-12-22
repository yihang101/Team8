package com.example.demo.controller;

import com.example.demo.Mapper.GoodMapper;
import com.example.demo.Mapper.HisGoodMapper;
import com.example.demo.entiy.Customer;
import com.example.demo.entiy.Good;
import com.example.demo.entiy.HisGood;
import com.example.demo.entiy.Namenaem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hisg")
public class HisGoodController {
    @Autowired
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
        Good good1 = null;
        good1 = goodMapper.getall2();
        System.out.println(good1);
        if(good1==null) {
            str=1;           //查找good是否为空，为空返回0
        }else {
        System.out.println(namenaem.getGoodname()+namenaem.getCustname());
        good1 =  goodMapper.find2(namenaem.getGoodname());
        HisGood hisg = new HisGood();
        hisg.setInformation(good1.getInformation());
        hisg.setName(good1.getName());
        hisg.setPrice(good1.getPrice());
        hisg.setUrl(good1.getUrl());
        hisg.setCustname(namenaem.getCustname());
            System.out.println(hisg);
        hisGoodMapper.save(hisg);
        goodMapper.delete(namenaem.getGoodname());
        }
        return str;
    }
}
