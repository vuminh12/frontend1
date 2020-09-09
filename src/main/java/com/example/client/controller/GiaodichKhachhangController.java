package com.example.client.controller;

import com.example.client.model.GiaodichKhachhang;
import com.example.client.model.Nhanvien;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/giaodichKhachhang")
public class GiaodichKhachhangController {
    private RestTemplate rest = new RestTemplate();

    // get data
    @GetMapping
    public String showForm(Model model) {
        List<GiaodichKhachhang> giaodichKhachhangs = Arrays
                .asList(rest.getForObject("http://localhost:8080/giaodichKhachhang", GiaodichKhachhang[].class));
        model.addAttribute("giaodichKhachhangs", giaodichKhachhangs);
        return "giaodichKhachhang";
    }
    // add
    @GetMapping("/add-giaodichKhachhang")
    public String createGiaodichKhachhang(Model model){
        model.addAttribute("giaodichKhachhang",new GiaodichKhachhang());
        return ("addGiaodichKhachhang");
    }
    //add
    @PostMapping
    public String saveGiaodichKhachHang(
            @RequestParam("magiaodich") String magiaodich
            , @RequestParam("makhachhang") String makhachhang
            , @RequestParam("loaigiaodich") String loaigiaodich
            , @RequestParam("sotiengiaodich") int sotiengiaodich
            , @RequestParam("mataikhoannhan") String mataikhoannhan
            , @RequestParam("ngaygiaodich") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaygiaodich
            ,@RequestParam("manhanvienthuchien") String manhanvienthuchien){

        GiaodichKhachhang giaodichKhachhang = new GiaodichKhachhang();
        giaodichKhachhang.setMagiaodich(magiaodich);
        giaodichKhachhang.setMakhachhang(makhachhang);
        giaodichKhachhang.setLoaigiaodich(loaigiaodich);
        giaodichKhachhang.setMataikhoannhan(mataikhoannhan);
        giaodichKhachhang.setSotiengiaodich(sotiengiaodich);
        giaodichKhachhang.setNgaygiaodich(ngaygiaodich);
        giaodichKhachhang.setManhanvienthuchien(manhanvienthuchien);
        rest.postForObject("http://localhost:8080/giaodichKhachhang", giaodichKhachhang, GiaodichKhachhang.class);
        return "redirect:/giaodichKhachhang";
    }
    @GetMapping("/search-giaodichKhachhang")
    public String searchgiaodichKhachhang(@RequestParam("id")String id,Model model){
        GiaodichKhachhang  giaodichKhachhang = rest.getForObject("http://localhost:8080/giaodichKhachhang/search-giaodichKhachhang/{id}", GiaodichKhachhang.class,id);

        if(giaodichKhachhang!=null && giaodichKhachhang.getMagiaodich().equals(id)){
            model.addAttribute("giaodichKhachhang",giaodichKhachhang);
            return "addGiaodichKhachhang";
        }
        else
            return "error404";
    }
}
