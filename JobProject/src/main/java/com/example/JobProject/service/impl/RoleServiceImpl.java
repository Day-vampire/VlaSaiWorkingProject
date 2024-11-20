package com.example.JobProject.service.impl;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.entity.Role;
import com.example.JobProject.mapper.RoleMapper;
import com.example.JobProject.repository.RoleRepository;
import com.example.JobProject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto findByName(String name) {
        return null;
    }

    @Cacheable(value = "roles", key = "#id")
    public RoleDto findById(long id) {
        return roleMapper.toRoleDto(roleRepository.findById(id));
    }

    //@Cacheable(value = "roles")
    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleDto).toList();
    }

    public Role save(RoleDto roleDto) {

        Role role = Role.builder()
                .name(roleDto.getName())
                .build();
        return roleRepository.save(role);
    }
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
