package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.User_Profile;
import com.soultech.productmanagement.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller responsible for handling user registration-related endpoints.
 * This includes rendering the registration form and processing submitted data.
 *
 * Endpoints:
 * - GET /api/registration: display registration form
 * - POST /api/register: handle registration submission
 *
 * Author: Solomon Demisse
 */
@Controller
@RequestMapping("/api")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * Handles GET requests to the registration page.
     * Adds an empty {@link User_Profile} object to the model to be filled by the form.
     *
     * @param model the UI model to hold form attributes
     * @return the name of the Thymeleaf registration view template
     */
    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userProfile", new User_Profile());
        return "registration";
    }

    /**
     * Handles POST requests for user registration.
     * Accepts form-submitted {@link User_Profile} data and passes it to the service layer
     * for saving the user and profile, then redirects to the login page.
     *
     * @param userProfile the submitted user profile data
     * @return redirect path to login page upon successful registration
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userProfile") User_Profile userProfile) {
        registrationService.addUserProfile(userProfile);
        return "redirect:/api/login";
    }
}
