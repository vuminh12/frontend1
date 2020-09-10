package com.example.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    public String showErrorPage(){
        return "error404";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
