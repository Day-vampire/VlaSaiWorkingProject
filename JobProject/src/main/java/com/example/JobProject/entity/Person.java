package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="persons")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String email;

    @OneToOne(mappedBy ="person")
    private User user;

    @OneToOne
    @JoinColumn(name = "passport_data_id")
    private PassportData passportData;
}
