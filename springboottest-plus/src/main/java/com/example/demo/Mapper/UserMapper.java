package com.example.demo.Mapper;

import com.example.demo.entiy.CustomerZC;
import com.example.demo.entiy.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;
//User接口

public interface UserMapper {


   @Select("select * from login")

    List<User> findAll();

    @Select("select * from login where name = #{name}")
    User find(String name);

    @Select("select * from customerlogin where custname = #{custname}")
    CustomerZC findcust(String custname);

    @Update("insert into `login` VALUES (#{id}, #{name}, #{pwd});")
    @Transactional//事务的注解
    int save(User user);
}
