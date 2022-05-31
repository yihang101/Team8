package com.example.demo.controller.dto;

public class AliPay {
    private String subject;
    private String traceNo;
    private String totalAmount;
    private String alipayTraceNo;

    public String getAlipayTraceNo() {
        return alipayTraceNo;
    }

    public void setAlipayTraceNo(String alipayTraceNo) {
        this.alipayTraceNo = alipayTraceNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
