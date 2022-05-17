package com.example.demo.entiy;
import lombok.Data;

@Data
public class CustomerZC {

    private Integer id;
    private String custname;
    private String pwd;
    private String address;
    private String tel;

    public CustomerZC(Integer id, String custname, String pwd, String address, String tel) {
        this.id = id;
        this.custname = custname;
        this.pwd = pwd;
        this.address = address;
        this.tel = tel;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
}
