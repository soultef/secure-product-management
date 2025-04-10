package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.User_Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class RegistrationController {

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userProfile", new User_Profile());
        return "registration";
    }


}
