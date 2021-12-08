package com.example.demo.Mapper;

import com.example.demo.entiy.Login;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LoginMapper {
    @Update("UPDATE `test`.`login` SET `pwd` = #{pwd} WHERE `id`=1;")
    void change(String pwd);

}
