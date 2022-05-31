package com.example.demo.mapper;

import org.apache.ibatis.annotations.Update;

public interface LoginMapper {
    @Update("UPDATE `test`.`login` SET `pwd` = #{pwd} where 1 ORDER BY `id` DESC LIMIT 1;")
    void change(String pwd);

}
