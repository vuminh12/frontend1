package com.example.client.controller;

import com.example.client.model.luongnhanvien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/luongnhanvien")
public class LuongnhanvienController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String showForm(Model model) {
        List<luongnhanvien> luongnhanviens = Arrays
                .asList(rest.getForObject("http://localhost:8080/luongnhanvien", luongnhanvien[].class));
        model.addAttribute("luongnhanviens", luongnhanviens);
        return "luongnhanvien";
    }
}
