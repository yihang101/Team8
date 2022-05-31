package com.example.demo.service;

import com.example.demo.entiy.Good;
import com.example.demo.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodService {
    @Autowired
    @Resource
    private GoodMapper goodMapper;

    public List<Good> getGood(){
        return goodMapper.getall();
    }

    public String ice(String name){
        goodMapper.ice(name);
        return "success";
    }

    public String reice(String name){
        goodMapper.reice(name);
        return "success";
    }

    public String addGood(Good good){//@RequestBody 将接受的数据包装惩实体 发布商品逻辑判断
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

    public List<Good> one(Good good){
        return goodMapper.selectone(good);
    }

    public List<Good> getGood2(String search){
        return goodMapper.search(search);
    }
}
