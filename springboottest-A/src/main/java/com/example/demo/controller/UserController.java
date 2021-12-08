package com.example.demo.controller;

import com.example.demo.Mapper.CustMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entiy.CustomerZC;
import com.example.demo.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;



@RestController//让其他文件能找到地址

@RequestMapping("/user")
@Service
public class UserController  {

    @Autowired

    @Resource//调用接口类
    UserMapper userMapper;

    @Resource
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
    public int zhuce(@RequestBody CustomerZC customerzc){

        int str =0;
        CustomerZC customer= null;
        customer=custMapper.find(customerzc.getCustname());
        System.out.println(customerzc);
        System.out.println(customer);

        if(customer!=null){
            str=4;                  //用户名已存在
        }else {
            boolean flagtel = true;
            boolean flagusername = true;
            boolean flagpwd = true;
            char[] tel = customerzc.getTel().toCharArray();

            for (int i = 0; i < 11; i++) {
                if (tel[i] < 48 || tel[i] > 59) {
                    flagtel = false;
                }
            }
            if (flagtel == false) {
                str = 1;//手机号码应为数字
                System.out.println(1);
            }
            char[] username = customerzc.getCustname().toCharArray();
            int shuzi1 = 0;
            int zimu1 = 0;
            for (int i = 0; i < customerzc.getCustname().length(); i++) {
                if (username[i] >= '0' && username[i] <= '9') {
                    shuzi1 = 1;
                } else if (username[i] >= 'A' && username[i] <= 'Z' || username[i] >= 'a' && username[i] <= 'z') {
                    zimu1 = 1;
                } else {
                    flagusername = false;
                    break;
                }
            }
            if (shuzi1 == 1 && zimu1 == 1 && flagusername == true) {
                flagusername = true;
            } else {
                flagusername = false;
                str=2;          //用户名不规范
                System.out.println(2);
            }
            char[] pwd = customerzc.getPwd().toCharArray();
            int shuzi2 = 0;
            int zimu2 = 0;
            for (int i = 0; i < customerzc.getPwd().length(); i++) {
                if (pwd[i] >= '0' && pwd[i] <= '9') {
                    shuzi2 = 1;
                } else if (pwd[i] >= 'A' && pwd[i] <= 'Z' || pwd[i] >= 'a' && pwd[i] <= 'z') {
                    zimu2 = 1;
                } else {
                    flagpwd = false;
                    break;
                }
            }
            if (shuzi2 == 1 && zimu2 == 1 && flagpwd == true) {
                flagpwd = true;
            } else {
                flagpwd = false;
                str = 3;                //密码不规范
                System.out.println(3);
            }
            System.out.println(flagtel);
            System.out.println(flagusername);
            System.out.println(flagpwd);
            System.out.println(customerzc);
            if (flagpwd == true && flagpwd == true && flagusername == true) {
                custMapper.zhuce(customerzc);
            }
        }
        return str;                 //若返回为0则正确
    }
    @PostMapping("/address")
    public int upaddress(@RequestBody CustomerZC customerZC){
        System.out.println(customerZC);
        custMapper.upaddress(customerZC);
        return 1;
    }

}


