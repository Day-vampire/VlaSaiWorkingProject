package com.example.JobProject.service.impl;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.exception.AlreadyExistsException;
import com.example.JobProject.exception.NotFoundException;
import com.example.JobProject.mapper.RoleMapper;
import com.example.JobProject.repository.RoleRepository;
import com.example.JobProject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Transactional(readOnly = true)
    public RoleDto findByName(String name) {
        return roleRepository
                .findByName(name)
                .map(roleMapper::toRoleDto)
                .orElseThrow(()-> new NotFoundException("Role with name %s not found".formatted(name)));
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "roles", key = "#id")
    public RoleDto findById(long id) {
        return roleRepository
                .findById(id)
                .map(roleMapper::toRoleDto)
                .orElseThrow(()-> new NotFoundException("Role with id %d not found".formatted(id)));
    }

    @Transactional(readOnly = true)
    //@Cacheable(value = "roles")
    public List<RoleDto> findAll() {
        return roleRepository
                .findAll()
                .stream()
                .map(roleMapper::toRoleDto)
                .toList();
    }

    @Transactional
    public RoleDto save(RoleDto roleDto) {
        String roleName = roleDto.getName();
        if (roleRepository.findByName(roleName) != null) {
            throw new AlreadyExistsException("Role with name: %s already exists".formatted(roleName));
        }
        roleRepository.saveAndFlush(roleMapper.toRole(roleDto));
        return roleDto;
    }

    @Transactional
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

}
