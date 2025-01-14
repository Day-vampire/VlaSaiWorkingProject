package com.example.JobProject.service;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.entity.Role;

import java.util.List;

public interface RoleService {
    RoleDto findByName(String name);
    RoleDto findById(long id);
    List<RoleDto> findAll();
    void delete(Long id);
    RoleDto save(RoleDto roleDto);
}
