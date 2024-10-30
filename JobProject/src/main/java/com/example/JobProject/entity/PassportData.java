package com.example.JobProject.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="passport_data")
public class PassportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOfIssue; // дата выдачи паспорта
    private Date validityPeriod; // дата конца срока действия паспорта
    private String identificationNumber;

    @OneToOne(mappedBy ="passportData")
    private Person person;
}
