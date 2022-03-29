package com.example.clothes.controllers;

import com.example.clothes.dto.UserView;
import com.example.clothes.services.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/api/admin/user")
public class UserAdminController {
    private final UserDetailsServiceImpl userService;
    public UserAdminController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserView> findAll(){
        return userService.findAll();
    }
}
