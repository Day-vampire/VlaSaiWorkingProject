package com.example.JobProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String name;
}
