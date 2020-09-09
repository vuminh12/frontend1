package com.example.client.controller;

import com.example.client.model.GiaodichThe;
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
@RequestMapping("/giaodichThe")
public class GiaodichTheController {
    private RestTemplate rest = new RestTemplate();

    // get data
    @GetMapping
    public String showForm(Model model) {
        List<GiaodichThe> giaodichThes = Arrays
                .asList(rest.getForObject("http://localhost:8080/giaodichThe", GiaodichThe[].class));
        model.addAttribute("giaodichThes", giaodichThes);
        return "giaodichThe";
    }
    // add
    @GetMapping("/add-giaodichThe")
    public String createGiaodichThe(Model model){
        model.addAttribute("giaodichThe",new GiaodichThe());
        return ("addGiaodichThe");
    }
    //add
    @PostMapping
    public String saveGiaodichThe(
            @RequestParam("magiaodich") String magiaodich
            , @RequestParam("mataikhoantietkiem") String mataikhoantietkiem
            , @RequestParam("loaigiaodich") String loaigiaodich
            , @RequestParam("sotiengiaodich") int sotiengiaodich
            , @RequestParam("mataikhoantindung") String mataikhoantindung
            , @RequestParam("ngaygiaodich") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaygiaodich
            ,@RequestParam("manhanvienthuchien") String manhanvienthuchien){

        GiaodichThe giaodichThe = new GiaodichThe();
        giaodichThe.setMagiaodich(magiaodich);
        giaodichThe.setMataikhoantietkiem(mataikhoantietkiem);
        giaodichThe.setLoaigiaodich(loaigiaodich);
        giaodichThe.setMataikhoantindung(mataikhoantindung);
        giaodichThe.setSotiengiaodich(sotiengiaodich);
        giaodichThe.setManhanvienthuchien(manhanvienthuchien);
        giaodichThe.setNgaygiaodich(ngaygiaodich);
        rest.postForObject("http://localhost:8080/giaodichThe", giaodichThe, GiaodichThe.class);
        return "redirect:/giaodichThe";
    }
    @GetMapping("/search-giaodichThe")
    public String searchgiaodichThe(@RequestParam("id")String id,Model model){
        GiaodichThe  giaodichThe = rest.getForObject("http://localhost:8080/giaodichThe/search-giaodichThe/{id}", GiaodichThe.class,id);

        if(giaodichThe!=null && giaodichThe.getMagiaodich().equals(id)){
            model.addAttribute("giaodichThe",giaodichThe);
            return "addGiaodichThe";
        }
        else
            return "error404";
    }
}
