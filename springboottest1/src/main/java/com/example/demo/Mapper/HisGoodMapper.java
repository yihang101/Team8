package com.example.demo.Mapper;

import com.example.demo.entiy.HisGood;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HisGoodMapper {
    @Select("select * from HisGood")
    List<HisGood> getall();

    @Update("UPDATE `test`.`hisgood` SET `custname` = #{name} WHERE `id` = 1;")
    void sell(String name);

    @Update("insert into `hisgood` VALUES  (#{id},#{name}, #{url},#{information},#{price},#{custname});")
    @Transactional
    void save(HisGood hisGood);
}
