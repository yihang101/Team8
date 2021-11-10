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

    @PutMapping("sell/{name}")
    public String sell(@PathVariable("name") String name){
        hisgm.sell(name);
        return "success";
    }

    @PostMapping("/find")
    public int find2(@RequestBody Namenaem namenaem){
        Good good1;
        good1 =  goodMapper.find2(namenaem.getGoodname());
        HisGood hisg = new HisGood();
        hisg.setInformation(good1.getInformation());
        hisg.setName(good1.getName());
        hisg.setPrice(good1.getPrice());
        hisg.setUrl(good1.getUrl());
        hisg.setCustomer(namenaem.getName());
        hisGoodMapper.save(hisg);
        goodMapper.delete(namenaem.getGoodname());
        return 1;
    }
}
