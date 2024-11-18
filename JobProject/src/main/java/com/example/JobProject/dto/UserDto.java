package com.example.JobProject.dto;

import com.example.JobProject.entity.Person;
import com.example.JobProject.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UserDto {

    private String Login;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long roleId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long personId;
}
