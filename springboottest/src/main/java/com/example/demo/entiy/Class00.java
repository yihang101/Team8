package com.example.demo.entiy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Class00 {

    private String classify1;
    private List classify;

    public String getClassify1() {
        return classify1;
    }

    public void setClassify1(String classify1) {
        this.classify1 = classify1;
    }

    public List getClassify() {
        return classify;
    }

    public void setClassify(List classify) {
        this.classify = classify;
    }
}
