package com.example.JobProject.controller;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.entity.Role;
import com.example.JobProject.service.impl.RoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("role")
@PreAuthorize("ROLE_ADMIN")
public class RoleController {
    private final RoleServiceImpl roleService;

    @PostMapping("create")
    public ResponseEntity<Role> save(@RequestBody RoleDto roledto) {
        return new ResponseEntity<>(roleService.save(roledto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        roleService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping ("roles")
    public ResponseEntity<List<RoleDto>> findAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

}
