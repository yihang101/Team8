package com.example.demo.entiy;

public class Collect {
    public int id;
    public int goodid;
    public int custid;

    public Collect(int goodid, int custid) {
        this.goodid = goodid;
        this.custid = custid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }
    public Collect(){}

}
