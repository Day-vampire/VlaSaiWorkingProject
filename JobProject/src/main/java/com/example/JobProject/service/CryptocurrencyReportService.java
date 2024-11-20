package com.example.JobProject.service;

import com.example.JobProject.dto.CryptocurrencyReportDto;
import com.example.JobProject.entity.CryptocurrencyReport;

import java.util.Date;
import java.util.List;

public interface CryptocurrencyReportService {
    List<CryptocurrencyReportDto> findByUserId(long userId);
    List<CryptocurrencyReportDto> findByCryptocurrencyReportTypeIdAndUserId(long cryptocurrencyReportTypeId, long userId);
    List<CryptocurrencyReportDto> findByCryptocurrencyIdAndUserId(String cryptocurrencyId, long userId);
    List<CryptocurrencyReportDto> findByReportDateAndUserId(Date reportDate, long userId);
    CryptocurrencyReportDto findByReportNameAndUserId(String reportName, long userId);

}
