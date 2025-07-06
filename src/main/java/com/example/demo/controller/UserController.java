package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    // GET all users
    @GetMapping("/All")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/create")
    public String showCreateForm(User user) {
        return "createUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        userService.getUserById(id).ifPresent(u -> model.addAttribute("user", u));
        return "editUser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable String id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}