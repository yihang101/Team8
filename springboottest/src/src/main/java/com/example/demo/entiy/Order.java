package com.example.demo.entiy;

public class Order {
    public Integer id;
    public String custid;
    public String conditio;
    private String tel;
    private String address;
    private String number;
    public String goodname;
    public String no;
    public String paymenttime;
    public String byNo;

    public String getPaymenttime() {
        return paymenttime;
    }

    public void setPaymenttime(String paymenttime) {
        this.paymenttime = paymenttime;
    }

    public String getByNo() {
        return byNo;
    }

    public void setByNo(String byNo) {
        this.byNo = byNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getConditio() {
        return conditio;
    }

    public void setConditio(String conditio) {
        this.conditio = conditio;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Order() {
    }
}
