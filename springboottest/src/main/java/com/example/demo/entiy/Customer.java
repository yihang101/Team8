package com.example.demo.entiy;

import lombok.Data;

@Data

public class Customer {
    private Integer id;
    private String custname;
    private String address;
    private String tel;
    private String goodname;
    private int number;

    public Customer(Integer id, String custname, String address, String tel, String goodname, int number) {
        this.id = id;
        this.custname = custname;
        this.address = address;
        this.tel = tel;
        this.goodname = goodname;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
