package com.example.demo.controller;

import com.example.demo.service.OrderService;
import com.example.demo.entiy.Order;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    @Resource
    private OrderService orderService;
    @PostMapping("insert")
    public void insertOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }
    @PostMapping("change1/{Id},{state}")
    public void change1(@PathVariable("Id")int id){ orderService.change1(id);
    }
    @PostMapping("change2/{Id}")
    public void change2(@PathVariable("Id")int id){
       orderService.change2(id);
    }
    @PostMapping("change3/{Id}")
    public void change3(@PathVariable("Id")int id){
        orderService.change3(id);
    }
    @PostMapping("change4/{Id}")
    public void change4(@PathVariable("Id")int id){
        orderService.change4(id);
    }
    @PostMapping("updatestate/{Id},{state}")
    public void updateCondition(@PathVariable("Id")int id,@PathVariable("state")String state){
        System.out.println(id+state);
    }
    @DeleteMapping("delete/{Id}")
    public void deleteOrder(@PathVariable("Id")int id){
        orderService.deleteOrder(id);
    }

    @GetMapping("custseeorder/{custId}")
    public List<Order> custGetOrder(@PathVariable("custId") String custId){
        return orderService.custGetOrder(custId);
    }

    @GetMapping("userseeorder")
    public List<Order> userGetOrder(){
        return orderService.userGetOrder();
    }


}
