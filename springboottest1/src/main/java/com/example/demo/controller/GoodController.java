package com.example.demo.controller;

import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.Good;
import com.example.demo.entiy.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    GoodMapper gm;
    @GetMapping("/get")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List<Good> getGood(){ return gm.getall();
    }

    @PutMapping("ice/{id}")
    public String ice(@PathVariable("id")int id){
        gm.ice(id);
        return "success";
    }
    @PutMapping("reice/{id}")
    public String reice(@PathVariable("id")int id){
        gm.reice(id);
        return "success";
    }
    /**@PostMapping("insert")
    public String addGood(@RequestBody Good good){//@RequestBody 将接受的数据包装惩实体 发布商品逻辑判断
        String str = "";
        Good good1;
        good1 = goodMapper.find2(good.getName());
        if(good.getPrice()<=0){
            str = "价格应大于0";
        }else if(good1.getName().equals(good.getName())){
            str = "已存在同类商品";
        }
        else{
            gm.save(good);
            str = "成功";
        }
        return str;
    }**/
    @PostMapping("insert")
    public String addGood(@RequestBody Good good){//@RequestBody 将接受的数据包装惩实体 发布商品逻辑判断
        String str = "";
        Good good1 = null;
        good1 = gm.getall2();
        System.out.println(good1);
        System.out.println(good);
        if(good1.getName()==null){
           if(good.getPrice()<=0){
            str = "2";//价格应大于0
            }
            else{
               gm.delete2();
                gm.updategood(good);
                str = "0";
        }
       }else{
            str="1";//已有商品
        }
        return str;
    }

    @PostMapping("one")
    public List<Good> one(@RequestBody Good good){
        return gm.selectone(good);
    }
}
