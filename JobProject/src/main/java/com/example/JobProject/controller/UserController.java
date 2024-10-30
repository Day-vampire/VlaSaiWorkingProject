package com.example.JobProject.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("")
    public ResponseEntity getUser(){
        try {
            return ResponseEntity.ok("good");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Произошда ошибка в UserController"+e.getMessage());
        }
    }
}
