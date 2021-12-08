package com.example.demo.controller;

import com.example.demo.Mapper.CustMapper;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("cust")
public class CustomerController {

    @Autowired
    @Resource
    GoodMapper goodMapper;
    @Resource
    CustMapper custm;
    @PostMapping("insert")
    public int addcust(@RequestBody Customer cust){
        int str=0;
        System.out.println(cust.getCustname());
        boolean flag= true;
        String str2="";
        str2= goodMapper.find1(cust.getGoodname());
        System.out.println(str2);
        System.out.println(goodMapper.getall2().getName());
        if(str2.equals("已冻结")){
            str=2;//商品已冻结无法填写信息
        }else {
            cust.setGoodname(goodMapper.getall2().getName());
            System.out.println(cust);
            custm.save(cust);
            str = 0;
            /**
            System.out.println(goodMapper.getall2().getName());
            char[] tel = cust.getTel().toCharArray();
            for (int i = 0; i < 11; i++) {
                if (tel[i] < 48 || tel[i] > 59) {
                    flag = false;
                }
            }
            if (cust.getTel().length() != 11) {
                str = 1;//手机号码位数不正确
            } else if (flag == false) {
                str = 1;//手机号码应为数字
            } else {
                cust.setGoodname(goodMapper.getall2().getName());
                System.out.println(cust);
                custm.save(cust);
                str = 0;
            }**/

        }
        return str;
    }
    @GetMapping("/get")
    public List<Customer> getall(){
        System.out.println(custm.getall());
        return custm.getall();

    }

    /*@PostMapping
    public result<> login(@RequestBody Customer cust){

    }*/

}
