package com.example.JobProject.mapper;

import com.example.JobProject.dto.UserDto;
import com.example.JobProject.entity.Role;
import com.example.JobProject.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T19:33:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setRoleId( userRoleId( user ) );
        userDto.setLogin( user.getLogin() );
        userDto.setId( user.getId() );
        userDto.setPassword( user.getPassword() );
        userDto.setStatus( user.isStatus() );

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.login( userDto.getLogin() );
        user.password( userDto.getPassword() );
        user.status( userDto.isStatus() );

        return user.build();
    }

    private Long userRoleId(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
