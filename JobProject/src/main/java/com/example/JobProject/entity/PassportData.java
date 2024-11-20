package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="passport_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfIssue; // дата выдачи паспорта
    private LocalDate  validityPeriod; // дата конца срока действия паспорта
    private String identificationNumber;
    private String country;

    @OneToOne(mappedBy ="passportData")
    private Person person;
}
