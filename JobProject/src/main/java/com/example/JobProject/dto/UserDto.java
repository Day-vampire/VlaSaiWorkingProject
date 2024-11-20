package com.example.JobProject.dto;

import com.example.JobProject.entity.Person;
import com.example.JobProject.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Getter
@Setter
public class UserDto {

    private String Login;

    private Long id;

    private String password;

    private boolean status;

    private Long roleId;

    private Long personId;
}
