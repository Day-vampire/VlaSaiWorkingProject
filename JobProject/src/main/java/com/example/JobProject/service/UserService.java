package com.example.JobProject.service;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.dto.UserDto;
import com.example.JobProject.entity.Role;
import com.example.JobProject.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto findByLogin(String login);
    UserDto findById(Long id);
    List<UserDto> findByStatus(Boolean status);
    List<UserDto> findByRole(Role role);
    void deleteById(Long id);
    User save(UserDto userDto);
    List<UserDto> findAll();
}
