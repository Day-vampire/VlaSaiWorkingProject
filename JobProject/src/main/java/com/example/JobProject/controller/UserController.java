package com.example.JobProject.controller;

import com.example.JobProject.aspect.MyAnnotationForCallRestriction;
import com.example.JobProject.aspect.MyAnnotationForLog;
import com.example.JobProject.dto.UserDto;
import com.example.JobProject.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    @MyAnnotationForLog
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/{status}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserDto> findByStatus(@PathVariable Boolean status) {
        return userService.findByStatus(status);
    }

    @GetMapping("/userName")
    @ResponseStatus(HttpStatus.OK)
    public String userAccess(Principal principal){
        if(principal == null){
            return null;
        }
        return principal.getName();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    @MyAnnotationForCallRestriction(limit = 5, duration = 60000)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/roles")
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public Map<String, Object> getUserRoles(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = authorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        response.put("roles", roles);
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
