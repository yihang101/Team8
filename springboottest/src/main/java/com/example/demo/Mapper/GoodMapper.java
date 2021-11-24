package com.example.demo.Mapper;

import com.example.demo.entiy.Good;
import com.example.demo.entiy.HisGood;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodMapper {
    @Update("insert into `good` VALUES (#{id},#{name},#{url},#{information},#{condition},#{price});")
    @Transactional
    void save(Good good);
    @Update("insert into `good` VALUES (#{id},#{name},#{url},#{information},#{condition},#{price});")
    @Transactional
    void save2(Good good);
    @Select("select * from good")
    List<Good> getall();
    @Select("select * from good")
    Good getall2();
    @Update("UPDATE `test`.`good` SET `url` = #{url} where 1 ORDER BY `id` DESC LIMIT 1")
    void updateurl(String url);
    @Update("UPDATE `test`.`good` SET `name` = #{name},`information`=#{information},`condition`=#{condition}," +
            "`price`=#{price} where 1 ORDER BY `id` DESC LIMIT 1")
    void updategood(Good good);
    @Delete("DELETE FROM good WHERE name = #{name}")
    void delete(String name);
    @Delete("DELETE FROM customer ")
    void delete2();
    @Update("UPDATE `test`.`good` SET `condition` = '已冻结' WHERE `id` = #{id};")
    void ice(int id);
    @Select("select * from good where name = #{name}")
    Good find2(String name);
    @Select("select `condition` from good ")
    String find1(String name);

    @Update("UPDATE `test`.`good` SET `condition` = '未冻结' WHERE `id` = #{id};")
    void reice(int id);

    @Select("select * from good where name=#{name}")
    List<Good> selectone(Good good);
}
