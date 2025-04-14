package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class HomeController {

  @GetMapping({"/", "/home"})
    public String home(Model model) {
      model.addAttribute("user", new Users());
        return "product";
    }


}
