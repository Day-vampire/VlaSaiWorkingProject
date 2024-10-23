package com.example.JobProject.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="cryptocurrenciesReports")
public class CryptocurrencyReport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String reportName;
    private Date reportDate;
    private String cryptocurrencyId;
    @ManyToOne
    private User user;
    @ManyToOne
    private CryptocurrencyReportType cryptocurrencyReportType;
}
