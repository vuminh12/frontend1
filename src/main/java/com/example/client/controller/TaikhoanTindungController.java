package com.example.client.controller;


import com.example.client.model.TaikhoanTindung;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/taikhoanTindung")
public class TaikhoanTindungController {
    private RestTemplate rest = new RestTemplate();

    // get data
    @GetMapping
    public String showForm(Model model) {
        List<TaikhoanTindung> taikhoanTindungs = Arrays
                .asList(rest.getForObject("http://localhost:8080/taikhoanTindung", TaikhoanTindung[].class));
        model.addAttribute("taikhoanTindungs", taikhoanTindungs);
        return "taikhoanTindung";
    }
    // add
    @GetMapping("/add-taikhoanTindung")
    public String createTaikhoanTindung(Model model){
        model.addAttribute("taikhoanTindung",new TaikhoanTindung());
        return ("addTaiKhoanTindung");
    }
    //add
    @PostMapping
    public String saveTaikhoanTindung(
            @RequestParam("mataikhoantindung") String mataikhoantindung
            , @RequestParam("tenloaitaikhoan") String tenloaitaikhoan
            , @RequestParam("hanmuctoida") float hanmuctoida
            ,@RequestParam("sonohientai") float sonohientai
            ,@RequestParam("soduhientai") float soduhientai){

        TaikhoanTindung taikhoanTindung = new TaikhoanTindung();
        taikhoanTindung.setMataikhoantindung(mataikhoantindung);
        taikhoanTindung.setTenloaitaikhoan(tenloaitaikhoan);
        taikhoanTindung.setHanmuctoida(hanmuctoida);
        taikhoanTindung.setSoduhientai(soduhientai);
        taikhoanTindung.setSonohientai(sonohientai);
        rest.postForObject("http://localhost:8080/taikhoanTindung", taikhoanTindung, TaikhoanTindung.class);
        return "redirect:/taikhoanTindung";
    }

    //update
    @GetMapping("/edit-taikhoanTindung/{id}")
    public String editTaikhoanTindung(@PathVariable("id") String id, Model model){
        TaikhoanTindung taikhoanTindung=rest.getForObject("http://localhost:8080/taikhoanTindung/edit-taikhoanTindung/{id}", TaikhoanTindung.class,id);
        model.addAttribute("taikhoanTindung",taikhoanTindung);
        return "addTaiKhoanTindung";
    }
    @GetMapping("/delete-taikhoanTindung/{id}")
    public String deleteTaiKhoanTindung(@PathVariable("id") String id,Model model){
        rest.delete("http://localhost:8080/taikhoanTindung/delete-taikhoanTindung/{id}", id);
        List<TaikhoanTindung> taikhoanTindungs = Arrays
                .asList(rest.getForObject("http://localhost:8080/taikhoanTindung", TaikhoanTindung[].class));
        model.addAttribute("taikhoanTietkiems",taikhoanTindungs);
        return "redirect:/taikhoanTindung";
    }
    @GetMapping("/search-taikhoanTindung")
    public String searchTaiKhoanTindung(@RequestParam("id")String id,Model model){
        TaikhoanTindung taikhoanTindung = rest.getForObject("http://localhost:8080/taikhoanTindung/edit-taikhoanTindung/{id}", TaikhoanTindung.class,id);

        if(taikhoanTindung!=null && taikhoanTindung.getMataikhoantindung().equals(id)){
            model.addAttribute("taikhoanTindung",taikhoanTindung);
            return "addTaiKhoanTindung";
        }
        else
            return "error404";
    }
}
