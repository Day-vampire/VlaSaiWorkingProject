package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="account_reports")
@Getter
@Setter
public class AccountReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reportName;
    private Date reportDate;

    @ManyToOne
    @JoinColumn(name="cash_account_id")
    private CashAccount cashAccount;

    @ManyToOne
    @JoinColumn(name="account_report_type_id")
    private AccountReportType accountReportType;
}
