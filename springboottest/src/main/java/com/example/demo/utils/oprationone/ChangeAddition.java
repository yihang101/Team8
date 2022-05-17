package com.example.demo.utils.oprationone;

import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public interface ChangeAddition {
    void apply(int id,String addition);
}
