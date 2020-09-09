package com.example.client.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class GiaodichThe {

    private String magiaodich;
    private String mataikhoantietkiem;
    private String mataikhoantindung;
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

    public String getMataikhoantietkiem() {
        return mataikhoantietkiem;
    }

    public void setMataikhoantietkiem(String mataikhoantietkiem) {
        this.mataikhoantietkiem = mataikhoantietkiem;
    }

    public String getMataikhoantindung() {
        return mataikhoantindung;
    }

    public void setMataikhoantindung(String mataikhoantindung) {
        this.mataikhoantindung = mataikhoantindung;
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

    public void setManhanvienthuchien(String manhanviengiaodich) {
        this.manhanvienthuchien = manhanvienthuchien;
    }

    public String getLoaigiaodich() {
        return loaigiaodich;
    }

    public void setLoaigiaodich(String loaigiaodich) {
        this.loaigiaodich = loaigiaodich;
    }
}
