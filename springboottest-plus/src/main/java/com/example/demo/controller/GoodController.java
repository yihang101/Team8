package com.example.demo.controller;

import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.Good;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    GoodMapper goodMapper;
    @GetMapping("/get")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List<Good> getGood(){ return goodMapper.getall();
    }

    @PutMapping("ice/{name}")
    public String ice(@PathVariable("name")String name){
        goodMapper.ice(name);
        return "success";
    }
    @PutMapping("reice/{name}")
    public String reice(@PathVariable("name")String name){
        goodMapper.reice(name);
        return "success";
    }
   /** @PostMapping("insert")
    public String addGood(@RequestBody Good good){//@RequestBody 将接受的数据包装惩实体 发布商品逻辑判断
        String str = "";
        Good good1;
        good1 = goodMapper.find2(good.getName());
        if(good.getPrice()<=0){
            str = "1"; //""价格应大于0";
        }else if(good1.getName().equals(good.getName())){
            str = "2"; //"已存在同类商品";
        }
        else{
            goodMapper.save(good);
            str ="3"; // "成功";
        }
        return str;
    }**/
 @PostMapping("insert")
    public String addGood(@RequestBody Good good){//@RequestBody 将接受的数据包装惩实体 发布商品逻辑判断
        String str = "";
        Good good1 = null;
        good1 = goodMapper.find2(good.getName());
        System.out.println(good1);
         System.out.println(good);
        if(good1==null){
           if(good.getPrice()<=0){
            str = "2";//价格应大于0
            }
            else{
                goodMapper.save(good);
                str = "0";
        }
       }else{
            good.setNumber(good1.getNumber()+good.getNumber());
            goodMapper.upgood2(good);
            str="1";//添加库存
        }
        return str;
    }

    @PostMapping("one")
    public List<Good> one(@RequestBody Good good){
        return goodMapper.selectone(good);
    }
    //
   /** @GetMapping("/getcla/{classify}")
    public List<Good> getGood1(@PathVariable("classify")String classify){
        return goodMapper.selectcla(classify);
    }**/
    @GetMapping("/search/{search}")
    public List<Good> getGood2(@PathVariable("search")String search){
        return goodMapper.search(search);
    }
}
