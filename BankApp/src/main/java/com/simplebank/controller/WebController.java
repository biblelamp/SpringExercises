package com.simplebank.controller;

import com.simplebank.domain.EnumStatus;
import com.simplebank.domain.User;
import com.simplebank.domain.UserRole;
import com.simplebank.repository.UserRepository;
import com.simplebank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String login(User user) {
        userService.add(user);
        return "redirect:/";
    }
}
