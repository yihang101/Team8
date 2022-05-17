package com.example.demo.mapper;

import com.example.demo.entiy.BuyCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface BuyCarMapper {
    @Update("insert into buycar(custid,goodid) VALUES (#{custid}, #{goodid});")
    @Transactional
    void insertBuyCar(BuyCar buycar);

    @Select("select * from buycar where custid = #{id};")
    ArrayList<BuyCar> getBuyCar(int id);

    @Select("select * from buycar where id = #{id};")
    BuyCar getBuyCarinfo(int id);

    @Delete("delete from buycar where id = #{id};")
    void deleteBuyCar(int id);

}
