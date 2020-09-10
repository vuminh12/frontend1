package com.example.client.controller;

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
@RequestMapping("/nhanvien")
public class NhanvienController {
    private RestTemplate rest = new RestTemplate();

// get data
    @GetMapping
    public String showForm(Model model) {
        List<Nhanvien> nhanviens = Arrays
                .asList(rest.getForObject("http://localhost:8080/nhanvien", Nhanvien[].class));
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien";
    }
    // add
    @GetMapping("/add-nhanvien")
    public String createNhanvien(Model model){
        model.addAttribute("nhanvien",new Nhanvien());
        return ("addNhanVien");
    }
    //add
    @PostMapping
    public String saveNhanVien(
            @RequestParam("manhanvien") String manhanvien
            , @RequestParam("chungminhthu") int chungminhthu
            , @RequestParam("tennhanvien") String tennhanvien
            , @RequestParam("ngaysinh") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaysinh
            ,@RequestParam("bacnghe") int bacnghe
            ,@RequestParam("thamnien") int thamnien
            ,@RequestParam("machucvu") String machucvu){

        Nhanvien nhanvien = new Nhanvien();
        nhanvien.setManhanvien(manhanvien);
        nhanvien.setTennhanvien(tennhanvien);
        nhanvien.setChungminhthu(chungminhthu);
        nhanvien.setNgaysinh(ngaysinh);
        nhanvien.setBacnghe(bacnghe);
        nhanvien.setMachucvu(machucvu);
        nhanvien.setThamnien(thamnien);
        rest.postForObject("http://localhost:8080/nhanvien", nhanvien, Nhanvien.class);
        return "redirect:/nhanvien";
    }

    //update
    @GetMapping("/edit-nhanvien/{id}")
    public String editNhanVien(@PathVariable("id") String id, Model model){
        Nhanvien nhanvien=rest.getForObject("http://localhost:8080/nhanvien/edit-nhanvien/{id}", Nhanvien.class,id);
        model.addAttribute("nhanvien",nhanvien);
        return "addNhanVien";
    }
    @GetMapping("/delete-nhanvien/{id}")
    public String deleteNhanVien(@PathVariable("id") String id,Model model){
        rest.delete("http://localhost:8080/nhanvien/delete-nhanvien/{id}", id);
        List<Nhanvien> nhanviens = Arrays
                .asList(rest.getForObject("http://localhost:8080/nhanvien", Nhanvien[].class));
        model.addAttribute("nhanviens",nhanviens);
        return "redirect:/nhanvien";
    }
//    @GetMapping("/search-nhanvien")
//    public String searchNhanVien(@RequestParam("id")String id,Model model){
//        System.out.println(id);
//        Nhanvien nhanvien = rest.getForObject("http://localhost:8080/nhanvien/edit-nhanvien/{id}", Nhanvien.class,id);
//
//        if(nhanvien!=null && nhanvien.getManhanvien().equals(id)){
//            model.addAttribute("nhanvien",nhanvien);
//            return "addNhanVien";
//        }
//        else
//            return "error404";
//    }
    @PostMapping("/search-nhanvien")
    public String showSearchResult(@RequestParam String searchName,Model model){
        List<Nhanvien> nhanviens = Arrays.asList(rest.getForObject("http://localhost:8080/nhanvien/search-nhanvien/"+searchName,Nhanvien[].class));
        model.addAttribute("nhanviens",nhanviens);
        return "nhanvien";
    }
}
