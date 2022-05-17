package com.example.demo.entiy;

public class Goodbc {
    private Integer goodid;
    private String name;
    private String url;
    private String information;
    private float price;
    private int number;
    private String condition;
    private String classify1;
    private String classify2;
    private int buynum;
    private float globalprice;


    public Goodbc(Integer goodid, String name, String url, String information, float price, int number, String condition, String classify1, String classify2, int buynum, float globalprice) {
        this.goodid = goodid;
        this.name = name;
        this.url = url;
        this.information = information;
        this.price = price;
        this.number = number;
        this.condition = condition;
        this.classify1 = classify1;
        this.classify2 = classify2;
        this.buynum = buynum;
        this.globalprice = globalprice;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getClassify1() {
        return classify1;
    }

    public void setClassify1(String classify1) {
        this.classify1 = classify1;
    }

    public String getClassify2() {
        return classify2;
    }

    public void setClassify2(String classify2) {
        this.classify2 = classify2;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    public float getGlobalprice() {
        return globalprice;
    }

    public void setGlobalprice(float globalprice) {
        this.globalprice = globalprice;
    }


}
