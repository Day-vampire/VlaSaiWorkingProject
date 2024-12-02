package com.example.JobProject.service;

import com.example.JobProject.dto.AccountReportDto;
import com.example.JobProject.entity.AccountReport;

import java.util.Date;
import java.util.List;

public interface AccountReportService {
    List<AccountReportDto> findByCashAccountId(Long cashAccountId);
    List<AccountReportDto> findByAccountReportTypeId(Long accountReportTypeId);
    List<AccountReportDto> findByCashAccountIdAndReportDate(Long cashAccountId, Date reportDate);
}
