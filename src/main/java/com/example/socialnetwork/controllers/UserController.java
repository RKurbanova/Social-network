package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/profile")
    public String profile(Model model)
    {
        Optional<User> user = userRepo.findByFirstNameAndLastName("Rusha", "Kurbanova");
        model.addAttribute("user", user.get());
        return "user/profile";
    }
}
