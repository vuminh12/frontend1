package com.example.client.controller;

import com.example.client.model.Sotaikhoanmotnhanvien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/sotaikhoanmotnhanvien")
public class SotaikhoanmotnhanvienController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String showForm(Model model) {
        List<Sotaikhoanmotnhanvien> sotaikhoanmotnhanviens = Arrays
                .asList(rest.getForObject("http://localhost:8080/sotaikhoanmotnhanvien", Sotaikhoanmotnhanvien[].class));
        model.addAttribute("sotaikhoanmotnhanviens", sotaikhoanmotnhanviens);
        return "sotaikhoanmotnhanvien";
    }
}
