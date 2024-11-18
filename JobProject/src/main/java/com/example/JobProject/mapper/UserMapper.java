package com.example.JobProject.mapper;

import com.example.JobProject.dto.UserDto;
import com.example.JobProject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(source = "role.id", target = "roleId")
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
