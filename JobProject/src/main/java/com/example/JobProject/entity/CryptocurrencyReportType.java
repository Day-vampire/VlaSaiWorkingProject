package com.example.JobProject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="cryptocurrency_report_types")
public class CryptocurrencyReportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "cryptocurrencyReportType")
    private List<CryptocurrencyReport> cryptocurrencyReports;
}
