package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="accountReports")
@Getter
@Setter
public class AccountReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reportName;
    private Date reportDate;
    @ManyToOne
    private CashAccount cashAccount;
    @ManyToOne
    private AccountReportType accountReportType;
}
