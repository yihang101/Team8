package com.example.demo.service;

import com.example.demo.mapper.CustMapper;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.mapper.HisGoodMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.entiy.CustomerZC;
import com.example.demo.entiy.Good;
import com.example.demo.entiy.HisGood;
import com.example.demo.entiy.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private GoodMapper goodMapper;

    @Resource
    private CustMapper custMapper;
    @Resource
    private HisGoodMapper hisGoodMapper;

    public void deleteOrder(int id){

        String gname=orderMapper.getGoodName(id);
        int gnum=goodMapper.getgoodnum(gname);
        gnum++;
        goodMapper.number(gnum,gname);
        orderMapper.deleteOrder(id);
    }

    public void change2(int id){
        String gname=orderMapper.getGoodName(id);
        int gnum=goodMapper.getgoodnum(gname);
        gnum--;
        goodMapper.number(gnum,gname);
        orderMapper.stockcomplete(id);
    }

    public void change4(int id){
        String gname=orderMapper.getGoodName(id);
        Good good=goodMapper.find2(gname);
        HisGood hisg=new HisGood();
        hisg.setName(good.getName());
        hisg.setNumber(1);
        hisg.setPrice(good.getPrice());
        hisg.setUrl(good.getUrl());
        hisg.setInformation(good.getInformation());
        String cname=orderMapper.getCustName(id);
        CustomerZC cust=custMapper.find(cname);
        System.out.println(cust.getCustname());
        hisg.setAddress(cust.getAddress());
        hisg.setCustname(cname);
        hisGoodMapper.save(hisg);
        orderMapper.tradecomplete(id);
    }

    public List<Order> userGetOrder() {
        return orderMapper.getUserOrder();
    }

    public void addOrder(Order order){
        orderMapper.insertOrder(order);
    }

    public void change1(int id){
        orderMapper.sellerconfirm(id);
    }
    public void change3(int id){
        orderMapper.startdelivery(id);
    }

    public List<Order> custGetOrder(String custId){
        return orderMapper.getCustOrder(custId);
    }

}
