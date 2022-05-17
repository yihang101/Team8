package com.example.demo.service;

import com.example.demo.entiy.Goodbc;
import com.example.demo.mapper.BuyCarMapper;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.entiy.BuyCar;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyCarService {
    @Autowired
    @Resource
    private BuyCarMapper buyCarMapper;
    @Resource
    private GoodMapper goodMapper;

    public void insertBuyCar(BuyCar buyCar){
        float price=goodMapper.selectPrice(buyCar.getGoodid());
        buyCar.setGlobalprice(price*buyCar.getBuynum());
        buyCarMapper.insertBuyCar(buyCar);
    }

    public List<Goodbc> getBuyCar(int custid){
        ArrayList<Goodbc> glist=new ArrayList<Goodbc>();
        Good good=null;
        ArrayList<BuyCar> blist=buyCarMapper.getBuyCar(custid);
        float globalprice;
        for(int i=0;i<blist.size();i++){
            good=goodMapper.find3(blist.get(i).getGoodid());
            good.setNumber(blist.get(i).getId());
            globalprice=blist.get(i).getBuynum()*good.getPrice();
            Goodbc goodbc=new Goodbc(good.getId(),good.getName(),good.getUrl(),good.getInformation(),good.getPrice(),good.getNumber(),good.getCondition(),good.getClassify1(),good.getClassify2(),blist.get(i).getBuynum(),globalprice);
            glist.add(goodbc);
        }
        return glist;
    }

    public void deleteBuyCar(int id){
        buyCarMapper.deleteBuyCar(id);
    }

    public void addBuyNum(int id){
        BuyCar buyCar=buyCarMapper.getBuyCarinfo(id);
        float price=buyCar.getGlobalprice()/buyCar.getBuynum();
        buyCar.setBuynum(buyCar.getBuynum()+1);
        buyCar.setGlobalprice(buyCar.getBuynum()*price);
        buyCarMapper.deleteBuyCar(id);
        buyCarMapper.insertBuyCar(buyCar);

    }

    public void cutBuyNum(int id){
        BuyCar buyCar=buyCarMapper.getBuyCarinfo(id);
        float price=buyCar.getGlobalprice()/buyCar.getBuynum();
        buyCar.setBuynum(buyCar.getBuynum()-1);
        buyCar.setGlobalprice(buyCar.getBuynum()*price);
        buyCarMapper.deleteBuyCar(id);
        buyCarMapper.insertBuyCar(buyCar);

    }
}
