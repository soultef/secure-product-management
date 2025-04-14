package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.User_Profile;
import com.soultech.productmanagement.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userProfile", new User_Profile());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userProfile") User_Profile userProfile) {
        registrationService.addUserProfile(userProfile);
        return "redirect:/api/login";
    }


}
