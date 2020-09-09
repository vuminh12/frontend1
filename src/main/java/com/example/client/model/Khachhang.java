package com.example.client.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Khachhang {
    private String makhachhang;
    private String tenkhachhang;
    private int chungminhthu;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;
    private String diachi;

    public Khachhang() {
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public int getChungminhthu() {
        return chungminhthu;
    }

    public void setChungminhthu(int chungminhthu) {
        this.chungminhthu = chungminhthu;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
