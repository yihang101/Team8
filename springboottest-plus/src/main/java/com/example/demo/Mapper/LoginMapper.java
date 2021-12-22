package com.example.demo.Mapper;

import com.example.demo.entiy.Login;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LoginMapper {
    @Update("UPDATE `test`.`login` SET `pwd` = #{pwd} where 1 ORDER BY `id` DESC LIMIT 1;")
    void change(String pwd);

}
