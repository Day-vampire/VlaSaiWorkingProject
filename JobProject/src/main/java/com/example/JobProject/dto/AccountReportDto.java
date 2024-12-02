package com.example.JobProject.dto;

import com.example.JobProject.entity.AccountReportType;
import com.example.JobProject.entity.CashAccount;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class AccountReportDto {
    private long id;
    private String reportName;
    private Date reportDate;
    private CashAccount cashAccountId;
    private AccountReportType accountReportTypeId;
}