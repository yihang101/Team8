package com.example.demo.controller;


import com.example.demo.service.CollectService;
import com.example.demo.entiy.Collect;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("collect")
public class CollectController {
    @Autowired
    @Resource
    private CollectService collectService;
    @PostMapping("collectone")
    public void insertCollect(@RequestBody Collect collect){
        collectService.insertCollect(collect);
    }

    @GetMapping("getcollect/{id}")
    public List<Good> getCollect(@PathVariable("id")int custid){
        return collectService.getCollect(custid);
    }

    @DeleteMapping("cancelcollect/{id}")
    public void deleteCollect(@PathVariable("id") int id){
        collectService.deleteCollect(id);
    }


}
