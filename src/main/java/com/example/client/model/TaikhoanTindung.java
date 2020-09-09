package com.example.client.model;


public class TaikhoanTindung {
    private String mataikhoantindung;
    private String tenloaitaikhoan;

    public void setSoduhientai(float soduhientai) {
        this.soduhientai = soduhientai;
    }

    public float getSonohientai() {
        return sonohientai;
    }

    public void setSonohientai(float sonohientai) {
        this.sonohientai = sonohientai;
    }

    private float soduhientai;
    private float sonohientai;
    private float hanmuctoida;

    public String getMataikhoantindung() {
        return mataikhoantindung;
    }

    public void setMataikhoantindung(String mataikhoantindung) {
        this.mataikhoantindung = mataikhoantindung;
    }

    public String getTenloaitaikhoan() {
        return tenloaitaikhoan;
    }

    public void setTenloaitaikhoan(String tenloaitaikhoan) {
        this.tenloaitaikhoan = tenloaitaikhoan;
    }

    public Float getSoduhientai() {
        return soduhientai;
    }

    public void setSoduhientai(Float soduhientai) {
        this.soduhientai = soduhientai;
    }

    public float getHanmuctoida() {
        return hanmuctoida;
    }

    public void setHanmuctoida(float hanmuctoida) {
        this.hanmuctoida = hanmuctoida;
    }
}
