package com.example.JobProject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="cryptocurrenciesReportTypes")
public class CryptocurrencyReportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<CryptocurrencyReport> cryptocurrencyReports;
}
