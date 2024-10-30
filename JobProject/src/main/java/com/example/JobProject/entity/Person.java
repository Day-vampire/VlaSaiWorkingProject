package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="persons")
@Setter
@Getter
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
