package com.example.JobProject.mapper;

import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.entity.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role role);
}
