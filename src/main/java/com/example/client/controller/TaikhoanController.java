package com.example.client.controller;

import com.example.client.model.Taikhoan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/taikhoan")
public class TaikhoanController {
    private RestTemplate rest = new RestTemplate();

    // get data
    @GetMapping
    public String showForm(Model model) {
        List<Taikhoan> taikhoans = Arrays
                .asList(rest.getForObject("http://localhost:8080/taikhoan", Taikhoan[].class));
        model.addAttribute("taikhoans", taikhoans);
        for(Taikhoan i : taikhoans)
        {
            System.out.println(i.getMakhachhang());
        }
        return "taikhoan";
    }
    // add
    @GetMapping("/add-taikhoan")
    public String createTaikhoan(Model model){
        model.addAttribute("taikhoan",new Taikhoan());
        return ("addTaiKhoan");
    }
    //add
    @PostMapping
    public String saveTaikhoan(
            @RequestParam("mataikhoan") String mataikhoan
            , @RequestParam("tenloaitaikhoan") String tenloaitaikhoan
            , @RequestParam("ngaytaotaikhoan") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaytaotaikhoan
            , @RequestParam("makhachhang") String makhachhang
            ,@RequestParam("manhanvientaotaikhoan") String manhanvientaotaikhoan
            ,@RequestParam("sodu") float sodu){

        Taikhoan taikhoan = new Taikhoan();
        taikhoan.setMataikhoan(mataikhoan);
        taikhoan.setTenloaitaikhoan(tenloaitaikhoan);
        taikhoan.setNgaytaotaikhoan(ngaytaotaikhoan);
        taikhoan.setManhanvientaotaikhoan(manhanvientaotaikhoan);
        taikhoan.setMakhachhang(makhachhang);
        taikhoan.setSodu(sodu);
        rest.postForObject("http://localhost:8080/taikhoan", taikhoan, Taikhoan.class);
        return "redirect:/taikhoan";
    }

    //update
    @GetMapping("/edit-taikhoan/{id}")
    public String editTaikhoan(@PathVariable("id") String id, Model model){
        Taikhoan taikhoan=rest.getForObject("http://localhost:8080/taikhoan/edit-taikhoan/{id}", Taikhoan.class,id);
        model.addAttribute("taikhoan",taikhoan);
        return "addTaiKhoan";
    }
    @GetMapping("/delete-taikhoan/{id}")
    public String deleteTaiKhoan(@PathVariable("id") String id,Model model){
        rest.delete("http://localhost:8080/taikhoan/delete-taikhoan/{id}", id);
        List<Taikhoan> taikhoans = Arrays
                .asList(rest.getForObject("http://localhost:8080/taikhoan", Taikhoan[].class));
        model.addAttribute("taikhoans",taikhoans);
        return "redirect:/taikhoan";
    }
    @GetMapping("/search-taikhoan")
    public String searchTaiKhoan(@RequestParam("id")String id,Model model){
        Taikhoan taikhoan = rest.getForObject("http://localhost:8080/taikhoan/edit-taikhoan/{id}", Taikhoan.class,id);

        if(taikhoan!=null && taikhoan.getMataikhoan().equals(id)){
            model.addAttribute("taikhoan",taikhoan);
            return "addTaiKhoan";
        }
        else
            return "error404";
    }
}
