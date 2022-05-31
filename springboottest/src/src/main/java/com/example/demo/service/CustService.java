package com.example.demo.service;

import com.example.demo.entiy.Caaddress;
import com.example.demo.mapper.CustMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustService {
    @Autowired
    @Resource
    private CustMapper custMapper;

    public List<String> getAddress(int custid){
        List<String> alist=custMapper.getaddressad(custid);
        String mraddress=custMapper.getaddress(custid);
        alist.add(0,mraddress);
        return alist;
    }

    public void alterDefaultAddress(Caaddress caaddress){
        String formerAddress=custMapper.getaddress(caaddress.getCustid());
        custMapper.addadaddress(formerAddress);
        custMapper.alteraddress(caaddress);
        caaddress.setAddress(formerAddress);
        custMapper.deleteaddressad(caaddress);
    }
}
