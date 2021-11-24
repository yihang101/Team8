package com.example.demo.controller;

import com.example.demo.Mapper.CustMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entiy.Customer;
import com.example.demo.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;


@RestController//让其他文件能找到地址

@RequestMapping("/user")
@Service
public class UserController  {

    @Autowired

    @Resource//调用接口类
    UserMapper userMapper;

   @Resource//调用接口类
    CustMapper custMapper;


    @PostMapping("/login")
    public int find(@RequestBody User user){
        int i =0;
        User user1 = null;

        user1 =  userMapper.find(user.getName());
        if(user1==null){
            i=0;
        }else{
            if(user1.getName().equals(user.getName())&&user1.getPwd().equals(user.getPwd())){
                i=1;
            }}
        return i;
    }
    @PostMapping("/zhuce")
    public int zhuce(@RequestBody Customer customer){

        int str =0;
        Customer cust=null;
        cust=custMapper.find(customer.getUsername());
        System.out.println(customer);
        System.out.println(cust);
    if(cust.getUsername().equals(customer.getUsername())){
        str=4;

    }else {
        boolean flagtel = true;

        boolean flagusername = true;
        boolean flagpwd = true;
        char[] tel = customer.getTel().toCharArray();
        for (int i = 0; i < 11; i++) {
            if (tel[i] < 48 || tel[i] > 59) {
                flagtel = false;
            }
        }
        if (flagtel == false) {
            str = 1;//手机号码应为数字
        }
        char[] username = customer.getUsername().toCharArray();
        int shuzi1 = 0;
        int zimu1 = 0;
        for (int i = 0; i < customer.getUsername().length(); i++) {
            if (username[i] >= '0' && username[i] <= '9') {
                shuzi1 = 1;
            } else if (username[i] >= 'A' && username[i] <= 'Z' || username[i] >= 'a' && username[i] <= 'z') {
                zimu1 = 1;
            } else {
                flagusername = false;
                str = 2;
                break;
            }
        }
        if (shuzi1 == 1 && zimu1 == 1 && flagusername == true) {
            flagusername = true;
        } else {
            flagusername = false;
        }
        char[] pwd = customer.getPwd().toCharArray();
        int shuzi2 = 0;
        int zimu2 = 0;
        for (int i = 0; i < customer.getPwd().length(); i++) {
            if (pwd[i] >= '0' && pwd[i] <= '9') {
                shuzi2 = 1;
            } else if (pwd[i] >= 'A' && pwd[i] <= 'Z' || pwd[i] >= 'a' && pwd[i] <= 'z') {
                zimu2 = 1;
            } else {
                flagpwd = false;
                str = 3;
                break;
            }
        }
        if (shuzi2 == 1 && zimu2 == 1 && flagpwd == true) {
            flagpwd = true;
        } else {
            flagpwd = false;
        }
        System.out.println(flagtel);
        System.out.println(flagusername);
        System.out.println(flagpwd);
        System.out.println(customer);
        if (flagpwd == true && flagpwd == true && flagusername == true) {
            System.out.println(123);
            custMapper.zhuce(customer);
        }
    }
        return str;
    }
}


