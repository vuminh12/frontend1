package com.example.client.model;


public class TaikhoanTindung {
    private String mataikhoantindung;
    private String tenloaitaikhoan;
    private Float sonohientai;
    private Float hanmuctoida;

    public Float getSonohientai() {
        return sonohientai;
    }

    public void setSonohientai(float sonohientai) {
        this.sonohientai = sonohientai;
    }

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
    public Float getHanmuctoida() {
        return hanmuctoida;
    }

    public void setHanmuctoida(float hanmuctoida) {
        this.hanmuctoida = hanmuctoida;
    }
}
