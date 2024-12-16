package com.example.JobProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
public class MainController {
    @GetMapping("/user")
    public String userAccess(Principal principal) {
        if (principal != null) {
            return principal.getName();
        }
        return "You are not logged in";
    }
}
