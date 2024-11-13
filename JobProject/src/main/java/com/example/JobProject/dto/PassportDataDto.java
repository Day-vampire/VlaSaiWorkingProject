package com.example.JobProject.dto;

import java.time.LocalDate;

public class PassportDataDto {
    private Long id;
    private LocalDate dateOfIssue; // дата выдачи паспорта
    private LocalDate  validityPeriod; // дата конца срока действия паспорта
    private String identificationNumber;
    private String country;
}
