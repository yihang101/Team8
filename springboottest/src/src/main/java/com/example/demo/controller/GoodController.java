package com.example.demo.controller;

import com.example.demo.mapper.GoodMapper;
import com.example.demo.entiy.Good;
import com.example.demo.service.GoodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    private GoodService goodService;
    @GetMapping("/get")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List<Good> getGood(){ return goodService.getGood();
    }

    @PutMapping("ice/{name}")
    public String ice(@PathVariable("name")String name){
        return goodService.ice(name);
    }
    @PutMapping("reice/{name}")
    public String reice(@PathVariable("name")String name){
        return goodService.reice(name);
    }
    @PostMapping("insert")
    public String addGood(@RequestBody Good good){//@RequestBody 将接受的数据包装惩实体 发布商品逻辑判断
        return goodService.addGood(good);
    }

    @PostMapping("one")
    public List<Good> one(@RequestBody Good good){
        return goodService.one(good);
    }
    @GetMapping("/search/{search}")
    public List<Good> getGood2(@PathVariable("search")String search){
        return goodService.getGood2(search);
    }
}
