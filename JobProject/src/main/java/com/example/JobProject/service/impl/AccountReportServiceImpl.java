package com.example.JobProject.service.impl;

import com.example.JobProject.dto.AccountReportDto;
import com.example.JobProject.entity.AccountReport;
import com.example.JobProject.mapper.AccountReportMapper;
import com.example.JobProject.repository.AccountReportRepository;
import com.example.JobProject.service.AccountReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountReportServiceImpl implements AccountReportService {
    private final AccountReportRepository accountReportRepository;
    private final AccountReportMapper accountReportMapper;

    @Override
    public List<AccountReportDto> findByCashAccountId(Long cashAccountId) {
        return accountReportRepository
                .findByCashAccountId(cashAccountId)
                .stream()
                .map(accountReportMapper::toAccountReportDto)
                .toList();
    }
    @Override
    public List<AccountReportDto> findByAccountReportTypeId(Long accountReportTypeId) {
        return accountReportRepository
                .findByAccountReportTypeId(accountReportTypeId)
                .stream()
                .map(accountReportMapper::toAccountReportDto)
                .toList();
    }

    @Override
    public List<AccountReportDto> findByCashAccountIdAndReportDate(Long cashAccountId, Date reportDate) {
        return accountReportRepository
                .findByCashAccountIdAndReportDate(cashAccountId, reportDate)
                .stream()
                .map(accountReportMapper::toAccountReportDto)
                .toList();
    }
}
