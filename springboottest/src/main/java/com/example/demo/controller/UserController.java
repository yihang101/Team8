package com.example.demo.controller;

import com.example.demo.Mapper.UserMapper;
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
   /*@GetMapping("get")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List<User> getUser(){
        return userMapper.findAll();
    }
    @PostMapping("insert")
    public int addUser(@RequestBody User user){//@RequestBody 将接受的数据包装惩实体
        userMapper.save(user);
        return 1;
    }*/

    @Resource
    UserMapper user2;

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


}


