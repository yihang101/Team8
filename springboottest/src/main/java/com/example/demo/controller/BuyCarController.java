package com.example.demo.controller;

import com.example.demo.entiy.Goodbc;
import com.example.demo.service.BuyCarService;
import com.example.demo.entiy.BuyCar;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/buycar")
public class BuyCarController {
    @Autowired
    @Resource
    private BuyCarService buyCarService;

    @PostMapping("addbuycar")
    public void insertBuyCar(@RequestBody BuyCar buyCar){
        buyCarService.insertBuyCar(buyCar);
    }

    @PostMapping("addnum/{id}")
    public void addBuyNum(@PathVariable("id")int id){
        buyCarService.addBuyNum(id);
    }

    @PostMapping("cutnum/{id}")
    public void cutBuyNum(@PathVariable("id")int id){
        buyCarService.cutBuyNum(id);
    }

    @GetMapping("getbuycar/{id}")
    public List<Goodbc> getBuyCar(@PathVariable("id")int custid){
        return buyCarService.getBuyCar(custid);
    }

    @DeleteMapping("cancelbuycar/{id}")
    public void deleteBuyCar(@PathVariable("id")int id) {
        buyCarService.deleteBuyCar(id);
    }


}
