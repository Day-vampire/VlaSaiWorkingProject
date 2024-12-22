package com.example.JobProject.controller;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.dto.UserDto;
import com.example.JobProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity getUser(){
        try {
            return ResponseEntity.ok("good");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Произошда ошибка в UserController"+e.getMessage());
        }
    }
    @GetMapping("/user")
    public String userAccess(Principal principal){
        if(principal == null){
            return null;
        }
        return principal.getName();
    }
    @GetMapping ("/all")
    public ResponseEntity<List<UserDto>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
