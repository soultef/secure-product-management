package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new Users());
        return "Home";
    }
}
