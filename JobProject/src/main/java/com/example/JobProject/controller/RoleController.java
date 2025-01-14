package com.example.JobProject.controller;

import com.example.JobProject.aspect.MyAnnotationForLog;
import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.entity.Role;
import com.example.JobProject.service.RoleService;
import com.example.JobProject.service.impl.RoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("roles")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @MyAnnotationForLog
    public RoleDto save(@RequestBody RoleDto roledto) {
        return roleService.save(roledto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public List<RoleDto> findAll() {
        return roleService.findAll();
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public RoleDto findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @GetMapping ("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public RoleDto findByName(@PathVariable String name) {
        return roleService.findByName(name);
    }

}
