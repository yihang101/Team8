package com.example.demo.Mapper;

import com.example.demo.entiy.Customer;
import com.example.demo.entiy.CustomerZC;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustMapper {
    @Update("insert into `customer` VALUES (#{id}, #{custname}, #{address}, #{tel},#{goodname}, #{number});")
    @Transactional
    void save(Customer Cust);

    @Select("select * from customer")
    List<Customer> getall();
    @Select("select * from customerlogin")
    List<CustomerZC> getall3();
    @Select("select * from customer where custname = #{custname}")
    List<Customer> getall2(String custname);
    @Update("insert into `customerlogin` VALUES (#{id}, #{custname}, #{pwd},#{address}, #{tel});")
    @Transactional
    void zhuce(CustomerZC Custzc);

    @Select("select * from `customerlogin` where custname = #{custname}")
    CustomerZC find(String custname);
    @Update("UPDATE `test`.`customerlogin` SET `address` = 'address' WHERE `custname` = #{custname};")
    void upaddress(CustomerZC customerZC);
}
