package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.UserModel;

@RestController
public class UserController {
    @GetMapping("/username")
    public String username(){
        String name = UserModel.GetNombre();
    }
}
