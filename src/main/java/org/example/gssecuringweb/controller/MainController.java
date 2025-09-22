package org.example.gssecuringweb.controller;

import org.example.gssecuringweb.model.Role;
import org.example.gssecuringweb.model.User;
import org.example.gssecuringweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        user.setRole(Role.USER); // Default role
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String adminPanel() {
        return "admin";
    }
}
