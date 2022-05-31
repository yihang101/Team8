package com.example.demo.mapper;

import com.example.demo.entiy.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OrderMapper {
    @Update("insert into orderr(custid,conditio,tel,address,number,goodname,no) VALUES (#{custid}, #{conditio}, #{tel},#{address},#{number},#{goodname},#{no});")
    @Transactional
    void insertOrder(Order order);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '商家确认' WHERE `Id` = #{id};")
    void sellerconfirm(int id);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '备货完成' WHERE `Id` = #{id};")
    void stockcomplete(int id);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '开始发货' WHERE `Id` = #{id};")
    void startdelivery(int id);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '交易完成' WHERE `Id` = #{id};")
    void tradecomplete(int id);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '已支付' and `paymenttime` = #{paymenttime} and `byno` = #{byNo} WHERE `no` = #{no};")
    void finishPay(String no,String paymenttime,String byNo);
    @Select("select `goodname` from `orderr` WHERE `Id` = #{id};")
    String getGoodName(int id);
    @Select("select `custname` from `orderr` WHERE `Id` = #{id};")
    String getCustName(int id);
    @Select("select * from `orderr` WHERE `custid` = #{custId};")
    List<Order> getCustOrder(String custId);
    @Select("select * from `orderr`;")
    List<Order> getUserOrder();
    @Delete("DELETE FROM `orderr` WHERE `Id` = #{id}")
    void deleteOrder(int id);

    @Select("select * from orderr where no =#{traceNo};")
    Order getByNo(String traceNo);

    @Update("update orderr set conditio = '已退款' where no = #{traceNo};")
    void updatePayState(String traceNo);
}
