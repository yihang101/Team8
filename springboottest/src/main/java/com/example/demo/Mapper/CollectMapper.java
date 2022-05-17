package com.example.demo.mapper;

import com.example.demo.entiy.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface CollectMapper {
    @Update("insert into collect(custid,goodid) VALUES (#{custid}, #{goodid});")
    @Transactional
    void insertCollect(Collect collect);

    @Select("select * from collect where custid = #{id};")
    ArrayList<Collect> getCollect(int id);

    @Delete("DELETE FROM `collect` WHERE `Id` = #{id}")
    void deleteCollect(int id);
}
