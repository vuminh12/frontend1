package com.example.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class HomepageController {
    @GetMapping()
    public ModelAndView showHomepage(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("null",null);
        return modelAndView;
    }
}
