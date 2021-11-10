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
        int str;
        boolean flag= true;

            char[] tel = cust.getTel().toCharArray();
            for (int i = 0; i < 11; i++) {
                if (tel[i] < 48 || tel[i] > 59) {
                    flag = false;
                }
            }
            if (cust.getTel().length() != 11) {
                str = 1;
            } else if (flag == false) {
                str = 1;
            } else {
                custm.save(cust);
                str = 2;
            }

        return str;
    }
    @GetMapping("/get")
    public List<Customer> getall(){
        return custm.getall();
    }
    /*@PostMapping
    public result<> login(@RequestBody Customer cust){

    }*/

}
