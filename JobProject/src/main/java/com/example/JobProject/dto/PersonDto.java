package com.example.JobProject.dto;

import com.example.JobProject.entity.PassportData;
import jakarta.validation.constraints.Email;

public class PersonDto {
    private Long id;
    private String name;
    private String surName;
    @Email
    private String email;
    private Long passportDataId;
}
