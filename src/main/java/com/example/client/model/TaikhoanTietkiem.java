package com.example.client.model;

public class TaikhoanTietkiem {
    private String mataikhoantietkiem;
    private String tenloaitaikhoan;
    private Float laisuathangthang;
    private Float sodutoithieu;

    public String getMataikhoantietkiem() {
        return mataikhoantietkiem;
    }

    public void setMataikhoantietkiem(String mataikhoantietkiem) {
        this.mataikhoantietkiem = mataikhoantietkiem;
    }

    public String getTenloaitaikhoan() {
        return tenloaitaikhoan;
    }

    public void setTenloaitaikhoan(String tenloaitaikhoan) {
        this.tenloaitaikhoan = tenloaitaikhoan;
    }

    public Float getLaisuathangthang() {
        return laisuathangthang;
    }

    public void setLaisuathangthang(float laisuathangthang) {
        this.laisuathangthang = laisuathangthang;
    }

    public Float getSodutoithieu() {
        return sodutoithieu;
    }

    public void setSodutoithieu(float sodutoithieu) {
        this.sodutoithieu = sodutoithieu;
    }
}
