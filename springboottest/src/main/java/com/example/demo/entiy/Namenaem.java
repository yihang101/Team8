package com.example.demo.entiy;

public class Namenaem {
    public String custname;
    public String goodname;
    public  int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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

    public Namenaem(String custname, String goodname, int number) {
        this.custname = custname;
        this.goodname = goodname;
        this.number = number;
    }
}
