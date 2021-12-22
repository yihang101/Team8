package com.example.demo.Mapper;

import com.example.demo.entiy.Classify;
import com.example.demo.entiy.CustomerZC;
import com.example.demo.entiy.Good;
import com.example.demo.entiy.HisGood;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodMapper {
    @Update("insert into `good` VALUES (#{id},#{name},#{url},#{information},#{condition},#{price},#{number},#{classify1},#{classify2});")
    @Transactional
    void save(Good good);
    @Update("insert into `good` VALUES (#{id},#{name},#{url},#{information},#{condition},#{price},#{number},#{classify1},#{classify2});")
    @Transactional
    void save2(Good good);
    @Select("select * from good where price>0")
    List<Good> getall();
    @Select("select * from good")
    Good getall2();
    @Update("UPDATE `test`.`good` SET `url` = #{url} where 1 ORDER BY `id` DESC LIMIT 1")
    void updateurl(String url);
    @Update("UPDATE `test`.`good` SET `name` = #{name},`information`=#{information},`condition`=#{condition}," +
            "`price`=#{price},`number`=#{number},`classify1`=#{classify1},`classify2`=#{classify2} where 1 ORDER BY `id` DESC LIMIT 1")
    void updategood(Good good);
    @Update("UPDATE `test`.`good` SET `number`=#{number} where `name` = #{name};")
    void upgood1(Good good);
    @Update("UPDATE `test`.`good` SET `name` = #{name},`information`=#{information},`condition`=#{condition}," +
            "`price`=#{price},`number`=#{number},`classify1`=#{classify1},`classify2`=#{classify2} where `name` = #{name};")
    void upgood2(Good good);
    @Update("insert into `good` VALUES  (#{id},#{name}, #{information},#{condition},#{price},#{number},#{classify1},#{classify2});")
    @Transactional
    void savegood(Good good);
    @Update("UPDATE `test`.`good` SET `number` = 'number' WHERE `name` = #{id};")
    void number(int number);
    @Delete("DELETE FROM good WHERE name = #{name}")
    void delete(String name);
    @Delete("DELETE FROM customer ")
    void delete2();
    @Update("UPDATE `test`.`good` SET `condition` = '已冻结' WHERE `name` = #{name};")
    void ice(String  name);
    @Select("select * from good where name = #{name}")
    Good find2(String name);
    @Select("select `condition` from good ")
    String find1(String name);

    @Update("UPDATE `test`.`good` SET `condition` = '未冻结' WHERE `name` = #{name};")
    void reice(String name);

    @Select("select * from good where name=#{name}")
    List<Good> selectone(Good good);

    @Select("select * from good where name regexp #{search}")
    List<Good> search(String search);

    @Select("select * from good where classify1 = #{classify1}")
    List<Good> selectcla1(String classify1);

    @Select("select * from good where classify2 = #{classify2}")
    List<Good> selectcla2(String classify2);


    @Select("select * from classify1 ")
    List<Classify> getclassify1();

    @Select("select * from classify2 where classify1 = #{classify1} ")
    List<Classify> getclassify2(String classify1);

    @Update("insert into `classify1` VALUES (#{id},#{classify1},#{classify2});")
    @Transactional
    void insertclassify1(Classify classify);

    @Update("insert into `classify2` VALUES (#{id},#{classify1},#{classify2});")
    @Transactional
    void insertclassify2(Classify classify);
    @Select("select * from classify1 where `classify1` = #{classify1}")
    Classify searchclassify1(String classify1);
    @Select("select * from classify2 where `classify2` = #{classify2}")
    Classify searchclassify2(String classify2);

    @Update("UPDATE `test`.`classify1` SET `classify1` = #{classify2} WHERE `classify1` = #{classify1};")
    void upclassify1(Classify classify);
    @Update("UPDATE `test`.`classify2` SET `classify2` = #{classify1} WHERE `classify2` = #{classify2};")
    void upclassify2(Classify classify);
}
