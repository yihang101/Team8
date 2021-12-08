package com.example.demo.Mapper;

import com.example.demo.entiy.Good;
import com.example.demo.entiy.HisGood;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodMapper {
    @Update("insert into `good` VALUES (#{id},#{name},#{url},#{information},#{condition},#{price},#{number},#{classify});")
    @Transactional
    void save(Good good);
    @Update("insert into `good` VALUES (#{id},#{name},#{url},#{information},#{condition},#{price},#{number},#{classify});")
    @Transactional
    void save2(Good good);
    @Select("select * from good where price>0")
    List<Good> getall();
    @Select("select * from good")
    Good getall2();
    @Update("UPDATE `test`.`good` SET `url` = #{url} where 1 ORDER BY `id` DESC LIMIT 1")
    void updateurl(String url);
    @Update("UPDATE `test`.`good` SET `name` = #{name},`information`=#{information},`condition`=#{condition}," +
            "`price`=#{price},`number`=#{number}`classify`=#{classify} where 1 ORDER BY `id` DESC LIMIT 1")
    void updategood(Good good);
    @Update("UPDATE `test`.`good` SET `number`=#{number} where `name` = #{name};")
    void upgood1(Good good);
    @Update("UPDATE `test`.`good` SET `name` = #{name},`information`=#{information},`condition`=#{condition}," +
            "`price`=#{price},`number`=#{number},`classify`=#{classify} where `name` = #{name};")
    void upgood2(Good good);
    @Update("insert into `good` VALUES  (#{id},#{name}, #{information},#{condition},#{price},#{number},#{classify});")
    @Transactional
    void savegood(Good good);
    @Update("UPDATE `test`.`good` SET `number` = 'number' WHERE `name` = #{id};")
    void number(int number);
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

    @Select("select * from good where classify = #{classify}")
    List<Good> selectcla(String classify);

    @Select("select * from good where name regexp #{search}")
    List<Good> search(String search);
}
