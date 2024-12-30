package com.example.JobProject.controller;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.dto.UserDto;
import com.example.JobProject.service.UserService;
import lombok.AllArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @GetMapping("/roles")
    public ResponseEntity<Map<String, Object>> getUserRoles(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();

        // Получаем роли из Authentication объекта
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Извлекаем роли
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // Добавляем роли в ответ
        response.put("roles", roles);

        return ResponseEntity.ok(response);
    }
}
