package com.example.JobProject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PassportDataDto {
    private Long id;
    private LocalDate dateOfIssue; // дата выдачи паспорта
    private LocalDate  validityPeriod; // дата конца срока действия паспорта
    private String identificationNumber;
    private String country;
}
