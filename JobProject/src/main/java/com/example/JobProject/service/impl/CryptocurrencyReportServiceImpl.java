package com.example.JobProject.service.impl;

import com.example.JobProject.dto.CryptocurrencyReportDto;
import com.example.JobProject.mapper.CryptocurrencyReportMapper;
import com.example.JobProject.repository.CryptocurrencyReportRepository;
import com.example.JobProject.service.CryptocurrencyReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptocurrencyReportServiceImpl implements CryptocurrencyReportService {
    private final CryptocurrencyReportRepository cryptocurrencyReportRepository;
    private final CryptocurrencyReportMapper cryptocurrencyReportMapper;

    @Override
    public List<CryptocurrencyReportDto> findByUserId(long userId) {
        return cryptocurrencyReportRepository
                .findByUserId(userId)
                .stream()
                .map(cryptocurrencyReportMapper::toCryptocurrencyReportDto)
                .toList();
    }

    @Override
    public List<CryptocurrencyReportDto> findByCryptocurrencyReportTypeIdAndUserId(long cryptocurrencyReportTypeId, long userId) {
        return cryptocurrencyReportRepository.
                findByCryptocurrencyReportTypeIdAndUserId(cryptocurrencyReportTypeId, userId).
                stream().
                map(cryptocurrencyReportMapper::toCryptocurrencyReportDto).
                toList();
    }

    @Override
    public List<CryptocurrencyReportDto> findByCryptocurrencyIdAndUserId(String cryptocurrencyId, long userId) {
        return cryptocurrencyReportRepository
                .findByCryptocurrencyIdAndUserId(cryptocurrencyId, userId)
                .stream()
                .map(cryptocurrencyReportMapper::toCryptocurrencyReportDto)
                .toList();
    }

    @Override
    public List<CryptocurrencyReportDto> findByReportDateAndUserId(Date reportDate, long userId) {
        return cryptocurrencyReportRepository
                .findByReportDateAndUserId(reportDate,userId)
                .stream()
                .map(cryptocurrencyReportMapper::toCryptocurrencyReportDto)
                .toList();
    }

    @Override
    public CryptocurrencyReportDto findByReportNameAndUserId(String reportName, long userId) {
        return cryptocurrencyReportRepository
                .findByReportNameAndUserId(reportName, userId)
                .map(cryptocurrencyReportMapper::toCryptocurrencyReportDto)
                .orElse(null);
    }
}
