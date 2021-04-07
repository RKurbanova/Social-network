package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@AllArgsConstructor
@NoArgsConstructor
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
