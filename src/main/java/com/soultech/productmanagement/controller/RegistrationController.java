package com.soultech.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class RegistrationController {

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

}
