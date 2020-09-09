package com.example.client.controller;

import com.example.client.model.Khachhang;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/khachhang")
public class KhachhangController {
    private RestTemplate rest = new RestTemplate();

    // get data
    @GetMapping
    public String showForm(Model model) {
        List<Khachhang> khachhangs = Arrays
                .asList(rest.getForObject("http://localhost:8080/khachhang", Khachhang[].class));
        model.addAttribute("khachhangs", khachhangs);
        return "khachhang";
    }
    // add
    @GetMapping("/add-khachhang")
    public String createKhachhang(Model model){
        model.addAttribute("khachhang",new Khachhang());
        return ("addKhachHang");
    }
    //add
    @PostMapping
    public String saveKhachHang(
            @RequestParam("makhachhang") String makhachhang
            , @RequestParam("chungminhthu") int chungminhthu
            , @RequestParam("tenkhachhang") String tenkhachhang
            , @RequestParam("ngaysinh") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaysinh
            ,@RequestParam("diachi") String diachi){

        Khachhang khachhang = new Khachhang();
        khachhang.setMakhachhang(makhachhang);
        khachhang.setTenkhachhang(tenkhachhang);
        khachhang.setChungminhthu(chungminhthu);
        khachhang.setNgaysinh(ngaysinh);
        khachhang.setDiachi(diachi);
        rest.postForObject("http://localhost:8080/khachhang", khachhang, Khachhang.class);
        return "redirect:/khachhang";
    }

    //update
    @GetMapping("/edit-khachhang/{id}")
    public String editKhachHang(@PathVariable("id") String id, Model model){
        Khachhang khachhang=rest.getForObject("http://localhost:8080/khachhang/edit-khachhang/{id}", Khachhang.class,id);
        model.addAttribute("khachhang",khachhang);
        return "addKhachHang";
    }
    @GetMapping("/delete-khachhang/{id}")
    public String deleteKhachHang(@PathVariable("id") String id,Model model){
        rest.delete("http://localhost:8080/khachhang/delete-khachhang/{id}", id);
        List<Khachhang> khachhangs = Arrays
                .asList(rest.getForObject("http://localhost:8080/nhanvien", Khachhang[].class));
        model.addAttribute("khachhangs",khachhangs);
        return "redirect:/khachhang";
    }
    @GetMapping("/search-khachhang")
    public String searchKhachHang(@RequestParam("id")String id,Model model){

        Khachhang khachhang = rest.getForObject("http://localhost:8080/khachhang/edit-khachhang/{id}", Khachhang.class,id);

        if(khachhang!=null && khachhang.getMakhachhang().equals(id)){
            model.addAttribute("khachhang" ,khachhang);
            return "addKhachHang";
        }
        else
            return "error404";
    }
}
