package com.example.client.controller;

import com.example.client.model.TaikhoanTietkiem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/taikhoanTietkiem")
public class TaikhoanTietkiemController {
    private RestTemplate rest = new RestTemplate();

    // get data
    @GetMapping
    public String showForm(Model model) {
        List<TaikhoanTietkiem> taikhoanTietkiems = Arrays
                .asList(rest.getForObject("http://localhost:8080/taikhoanTietkiem", TaikhoanTietkiem[].class));
        model.addAttribute("taikhoanTietkiems", taikhoanTietkiems);
        return "taikhoanTietkiem";
    }
    // add
    @GetMapping("/add-taikhoanTietkiem")
    public String createTaikhoanTietkiem(Model model){
        model.addAttribute("taikhoanTietkiem",new TaikhoanTietkiem());
        return ("addTaiKhoanTietkiem");
    }
    //add
    @PostMapping
    public String saveTaikhoanTietkiem(
            @RequestParam("mataikhoantietkiem") String mataikhoantietkiem
            , @RequestParam("tenloaitaikhoan") String tenloaitaikhoan
            , @RequestParam("laisuathangthang") float laisuathangthang
            ,@RequestParam("sodutoithieu") float sodutoithieu){

        TaikhoanTietkiem taikhoanTietkiem = new TaikhoanTietkiem();
        taikhoanTietkiem.setMataikhoantietkiem(mataikhoantietkiem);
        taikhoanTietkiem.setTenloaitaikhoan(tenloaitaikhoan);
        taikhoanTietkiem.setLaisuathangthang(laisuathangthang);
        taikhoanTietkiem.setSodutoithieu(sodutoithieu);
        rest.postForObject("http://localhost:8080/taikhoanTietkiem", taikhoanTietkiem, TaikhoanTietkiem.class);
        return "redirect:/taikhoanTietkiem";
    }

    //update
    @GetMapping("/edit-taikhoanTietkiem/{id}")
    public String editTaikhoanTietkiem(@PathVariable("id") String id, Model model){
        TaikhoanTietkiem taikhoanTietkiem=rest.getForObject("http://localhost:8080/taikhoanTietkiem/edit-taikhoanTietkiem/{id}", TaikhoanTietkiem.class,id);
        model.addAttribute("taikhoanTietkiem",taikhoanTietkiem);
        return "addTaiKhoanTietkiem";
    }
    @GetMapping("/delete-taikhoanTietkiem/{id}")
    public String deleteTaiKhoanTietkiem(@PathVariable("id") String id,Model model){
        rest.delete("http://localhost:8080/taikhoanTietkiem/delete-taikhoanTietkiem/{id}", id);
        List<TaikhoanTietkiem> taikhoanTietkiems = Arrays
                .asList(rest.getForObject("http://localhost:8080/taikhoanTietkiem", TaikhoanTietkiem[].class));
        model.addAttribute("taikhoanTietkiems",taikhoanTietkiems);
        return "redirect:/taikhoanTietkiem";
    }
    @GetMapping("/search-taikhoanTietkiem")
    public String searchTaiKhoanTietkiem(@RequestParam("id")String id,Model model){
        TaikhoanTietkiem taikhoanTietkiem = rest.getForObject("http://localhost:8080/taikhoanTietkiem/edit-taikhoanTietkiem/{id}", TaikhoanTietkiem.class,id);

        if(taikhoanTietkiem!=null && taikhoanTietkiem.getMataikhoantietkiem().equals(id)){
            model.addAttribute("taikhoanTietkiem",taikhoanTietkiem);
            return "addTaiKhoanTietkiem";
        }
        else
            return "error404";
    }
}
