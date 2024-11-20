package com.example.JobProject.dto;


import lombok.Data;

import java.util.Date;

@Data
public class CryptocurrencyReportDto {
    private Long id;
    private String reportName;
    private Date reportDate;
    private String cryptocurrencyId;
    private Long cryptocurrencyReportTypeId;
    private Long userId;
}
