package com.example.demo.service;

import com.example.demo.mapper.CollectMapper;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.entiy.Collect;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectService {
    @Autowired
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private GoodMapper goodMapper;

    public void insertCollect(Collect collect){
        collectMapper.insertCollect(collect);
    }

    public List<Good> getCollect(int custid){
        ArrayList<Good> glist=new ArrayList<Good>();
        Good good=null;
        ArrayList<Collect> clist=collectMapper.getCollect(custid);
        for(int i=0;i<clist.size();i++){
            good=goodMapper.find3(clist.get(i).getGoodid());
            good.setNumber(clist.get(i).getId());
            glist.add(good);
        }
        return glist;
    }

    public void deleteCollect(int id){
        collectMapper.deleteCollect(id);
    }
}
