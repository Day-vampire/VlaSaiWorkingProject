package com.example.JobProject.service.impl;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.dto.UserDto;
import com.example.JobProject.entity.Role;
import com.example.JobProject.entity.User;
import com.example.JobProject.mapper.UserMapper;
import com.example.JobProject.repository.RoleRepository;
import com.example.JobProject.repository.UserRepository;
import com.example.JobProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public UserDto findByLogin(String login) {
        return userRepository
                .findByLogin(login)
                .map(userMapper::toUserDto)
                .orElse(null);
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository
                .findById(id)
                .map(userMapper::toUserDto)
                .orElse(null);
    }

    @Override
    public List<UserDto> findByStatus(Boolean status) {
        return userRepository
                .findByStatus(status)
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public List<UserDto> findByRole(Role role) {
        return userRepository
                .findByRole(role)
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public User save(UserDto userDto) {
        User user = User
                .builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .status(userDto.isStatus())
                .role(roleRepository.findById(userDto.getRoleId()).orElse(null))
                .build();
        return userRepository.save(user);
    }
    @Cacheable(value = "users")
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toUserDto).toList();
    }
}
