package com.example.JobProject.service.impl;

import com.example.JobProject.dto.UserDto;
import com.example.JobProject.entity.Role;
import com.example.JobProject.entity.User;
import com.example.JobProject.exception.NotFoundException;
import com.example.JobProject.mapper.UserMapper;
import com.example.JobProject.repository.RoleRepository;
import com.example.JobProject.repository.UserRepository;
import com.example.JobProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public UserDto findByLogin(String login) {
        return userRepository
                .findByLogin(login)
                .map(userMapper::toUserDto)
                .orElseThrow(()-> new NotFoundException("User with login %s not found".formatted(login)));
    }

    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        return userRepository
                .findById(id)
                .map(userMapper::toUserDto)
                .orElseThrow(()-> new NotFoundException("User with id %d not found".formatted(id)));
    }

    @Transactional(readOnly = true)
    public List<UserDto> findByStatus(Boolean status) {
        return userRepository
                .findByStatus(status)
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<UserDto> findByRole(Role role) {
        return userRepository
                .findByRole(role)
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public User save(UserDto userDto) {
        User user = User
                .builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .status(userDto.isStatus())
                .role(roleRepository.findById(userDto.getRoleId()).orElseThrow(()-> new NotFoundException("Role with id %d not found in save user process".formatted(userDto.getRoleId()))))
                .build();
        return userRepository.save(user);
    }
//    @Cacheable(value = "users")
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toUserDto).toList();
    }
}
