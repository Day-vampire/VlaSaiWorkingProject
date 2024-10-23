package com.example.JobProject.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="passportData")
public class PassportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOfIssue; // дата выдачи паспорта
    private Date validityPeriod; // дата конца срока действия паспорта
    private String identificationNumber;
    @OneToOne
    private PassportData passportData;
}
