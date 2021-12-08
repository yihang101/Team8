package com.example.demo.Mapper;

import com.example.demo.entiy.Customer;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustMapper {
    @Update("insert into `customer` VALUES (#{id}, #{custname}, #{address}, #{tel},#{goodname});")
    @Transactional
    void save(Customer Cust);

    @Select("select * from customer")
    List<Customer> getall();
}
