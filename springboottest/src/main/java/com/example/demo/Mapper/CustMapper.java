package com.example.demo.mapper;

import com.example.demo.entiy.Caaddress;
import com.example.demo.entiy.Customer;
import com.example.demo.entiy.CustomerZC;
import com.example.demo.entiy.HisGood;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustMapper {
    @Update("insert into `customer` VALUES (#{id}, #{custname}, #{address}, #{tel},#{goodname}, #{number});")
    @Transactional
    void save(Customer Cust);

    @Select("select * from customer")//得到所有购买客户信
    List<Customer> getall();
    @Select("select * from customerlogin")
    List<CustomerZC> getall3();
    @Select("select * from hisgood where custname = #{custname}")
    List<HisGood> getall2(String custname);
    @Update("insert into `customerlogin` VALUES (#{id}, #{custname}, #{pwd},#{address}, #{tel});")
    @Transactional
    void zhuce(CustomerZC Custzc);

    @Select("select * from `customerzc` where `custname` = #{custname}")
    CustomerZC find(String custname);
    @Update("UPDATE `test`.`customerlogin` SET `address` = 'address' WHERE `custname` = #{custname};")
    void upaddress(CustomerZC customerZC);

    @Select("select * from `address_addition` where `custid` = #{custid};")
    List<String> getaddressad(int custid);
    @Select("select `address` from `custmerlogin` where `id` = #{custid};")
    String getaddress(int custid);
    @Update("insert into address_addition(address) values(#{address});")
    void addadaddress(String address);
    @Update("update custmerlogin set address = #{address} where id = #{custid};")
    void alteraddress(Caaddress caaddress);
    @Delete("delete from address_addition where custid = #{custid} and address = #{address};")
    void deleteaddressad(Caaddress caaddress);
}
