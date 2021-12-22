package com.example.demo.controller;

import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    @Resource
    GoodMapper goodMapper;

    @GetMapping("/getclassify1")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List getClassify1(){
        List<Classify> gclassify1 = (ArrayList)goodMapper.getclassify1();
        Iterator<Classify> giter1 = gclassify1.iterator();
        Classify g1 = null;
        List all = new ArrayList();
        while(giter1.hasNext()) {
            Class00 Class = new Class00();
            g1 = giter1.next();
            Class.setClassify1(g1.getClassify1());
            System.out.println(Class);
            List<Classify> gclassify2 = (ArrayList) goodMapper.getclassify2(g1.getClassify1());
            Iterator<Classify> giter2 = gclassify2.iterator();
            Classify g2 = null;
            List TxnInfo = new ArrayList();
            //创建map对象，并存值
            while (giter2.hasNext()) {
                g2 = giter2.next();
                System.out.println(g2.getClassify2());
                Map TxnInfo1 = new HashMap();
                TxnInfo1.put("classify2", g2.getClassify2());
                System.out.println(TxnInfo1);
                TxnInfo.add(TxnInfo1);
            }
            Class.setClassify(TxnInfo);
            System.out.println(Class);
            all.add(Class);

        }
        return all;
    }

    @GetMapping("/selectcla2/{option}")//决定URL二级地址，同一个@RequestMapping("user")下只允许出现一种不需要定义导航的@GetMapping和@PostMapping方法
    public List<Good> getClassify2(@PathVariable("option")String option){
        System.out.println(option);
        return goodMapper.selectcla2(option);
    }

    @PostMapping("/insertclassify1")
    public int insertclassify1(@RequestBody String classify1){
        int str = 0;
        Classify class2 = new Classify();
        class2 = goodMapper.searchclassify1(classify1);
        if (class2==null){
            Classify class1 = new Classify();
            class1.setClassify1(classify1);
            goodMapper.insertclassify1(class1);
        }else{
            str = 1;        //存在相同类别
        }

       return str;
    }
    @PostMapping("/insertclassify2")
    public int insertclassify1(@RequestBody Classify classify){
        int str = 0;
        Classify class2 = null;
        System.out.println(classify.getClassify2());
       class2 = goodMapper.searchclassify2(classify.getClassify2());
        System.out.println(class2);
        if(class2==null){
            goodMapper.insertclassify2(classify);
        }else{
            str=1;      //已存在相同类别
        }

        return str;
    }

    @PostMapping("/upclassify1")
    public int upclassify1(@RequestBody Classify classify){
        goodMapper.upclassify1(classify);
        return 1;
    }
    @PostMapping("/upclassify2")
    public int upclassify2(@RequestBody Classify classify){
        goodMapper.upclassify2(classify);
        return 1;
    }

}
