package com.example.client.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class GiaodichKhachhang {
    private String magiaodich;
    private String makhachhang;
    private String mataikhoannhan;
    private float sotiengiaodich;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaygiaodich;
    private String manhanvienthuchien;
    private String loaigiaodich;

    public String getMagiaodich() {
        return magiaodich;
    }

    public void setMagiaodich(String magiaodich) {
        this.magiaodich = magiaodich;
    }



    public float getSotiengiaodich() {
        return sotiengiaodich;
    }

    public void setSotiengiaodich(float sotiengiaodich) {
        this.sotiengiaodich = sotiengiaodich;
    }

    public Date getNgaygiaodich() {
        return ngaygiaodich;
    }

    public void setNgaygiaodich(Date ngaygiaodich) {
        this.ngaygiaodich = ngaygiaodich;
    }

    public String getManhanvienthuchien() {
        return manhanvienthuchien;
    }

    public void setManhanvienthuchien(String manhanvienthuchien) {
        this.manhanvienthuchien = manhanvienthuchien;
    }

    public String getLoaigiaodich() {
        return loaigiaodich;
    }

    public void setLoaigiaodich(String loaigiaodich) {
        this.loaigiaodich = loaigiaodich;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getMataikhoannhan() {
        return mataikhoannhan;
    }

    public void setMataikhoannhan(String mataikhoannhan) {
        this.mataikhoannhan = mataikhoannhan;
    }
}
