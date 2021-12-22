package com.example.demo.entiy;

public class Namenaem {
    public String custname;
    public String goodname;

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Namenaem(String custname, String goodname) {
        this.custname = custname;
        this.goodname = goodname;
    }
}
