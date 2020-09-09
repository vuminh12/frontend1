package com.example.client.controller;

import com.example.client.model.Chucvu;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/chucvu")
public class ChucVuController {
    private RestTemplate rest = new RestTemplate();

    // get data
    @GetMapping
    public String showForm(Model model) {
        List<Chucvu> chucvus = Arrays
                .asList(rest.getForObject("http://localhost:8080/chucvu", Chucvu[].class));
        model.addAttribute("chucvus", chucvus);
        return "chucvu";
    }
    // add
    @GetMapping("/add-chucvu")
    public String createChucvu(Model model){
        model.addAttribute("chucvu",new Chucvu());
        return ("addChucVu");
    }
    //add
    @PostMapping
    public String saveChucvu(
            @RequestParam("machucvu") String machucvu
            , @RequestParam("tenchucvu") String tenchucvu)
            {

        Chucvu chucvu = new Chucvu();
        chucvu.setMachucvu(machucvu);
        chucvu.setTenchucvu(tenchucvu);
        rest.postForObject("http://localhost:8080/chucvu", chucvu, Chucvu.class);
        return "redirect:/chucvu";
    }

    //update
    @GetMapping("/edit-chucvu/{id}")
    public String editChucVu(@PathVariable("id") String id, Model model){
        Chucvu chucvu=rest.getForObject("http://localhost:8080/chucvu/edit-chucvu/{id}", Chucvu.class,id);
        model.addAttribute("chucvu",chucvu);
        return "addChucVu";
    }
    @GetMapping("/delete-chucvu/{id}")
    public String deleteChucVu(@PathVariable("id") String id,Model model){
        rest.delete("http://localhost:8080/chucvu/delete-chucvu/{id}", id);
        List<Chucvu> chucvus = Arrays
                .asList(rest.getForObject("http://localhost:8080/chucvu", Chucvu[].class));
        model.addAttribute("chucvus",chucvus);
        return "redirect:/chucvu";
    }
    @GetMapping("/search-chucvu")
    public String searchChucVu(@RequestParam("id")String id,Model model){
        System.out.println(id);
        Chucvu chucvu = rest.getForObject("http://localhost:8080/chucvu/edit-chucvu/{id}", Chucvu.class,id);

        if(chucvu!=null && chucvu.getMachucvu().equals(id)){
            model.addAttribute("chucvu",chucvu);
            return "addChucVu";
        }
        else
            return "error404";
    }
}
