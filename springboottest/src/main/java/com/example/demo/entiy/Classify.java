package com.example.demo.entiy;

import lombok.Data;

@Data
public class Classify {
    private int id;
    private String classify1;
    private String classify2;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", classify1='" + classify1 + '\'' +
                ", classify2='" + classify2 + '\'' +
                '}';
    }
}
