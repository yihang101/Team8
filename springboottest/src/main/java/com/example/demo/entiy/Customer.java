package com.example.demo.entiy;

import lombok.Data;

@Data

public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String tel;
    private  String goodname;

    public Customer(Integer id, String name, String address, String tel, String goodname) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.goodname = goodname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }
}
