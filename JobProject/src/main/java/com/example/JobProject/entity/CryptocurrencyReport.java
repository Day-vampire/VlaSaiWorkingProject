package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="cryptocurrency_reports")
@Getter
@Setter
@EqualsAndHashCode
public class CryptocurrencyReport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String reportName;
    private Date reportDate;
    private String cryptocurrencyId;

    @ManyToOne
    @JoinColumn(name="cryptocurrency_report_type_id")
    private CryptocurrencyReportType cryptocurrencyReportType;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
