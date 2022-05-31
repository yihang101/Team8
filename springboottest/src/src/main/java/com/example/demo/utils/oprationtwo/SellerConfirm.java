package com.example.demo.utils.oprationtwo;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.utils.oprationone.ChangeAddition;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class SellerConfirm implements ChangeAddition {
    @Autowired
    @Resource
    private OrderMapper orderMapper;
    @Override
    public void apply(int id,String addition){
        orderMapper.sellerconfirm(id);
    }
}
