package com.example.socialnetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@RequestParam String login, Model model) {
        System.out.println("Login is: " + login);
        model.addAttribute("login", login);
        return "home";
    }
}
