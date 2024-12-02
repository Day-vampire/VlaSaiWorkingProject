package com.example.JobProject.mapper;

import com.example.JobProject.dto.CryptocurrencyReportTypeDto;
import com.example.JobProject.entity.CryptocurrencyReportType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CryptocurrencyReportTypeMapper {
    CryptocurrencyReportTypeDto toCryptocurrencyReportTypeDto(CryptocurrencyReportType cryptocurrencyReportType);
    CryptocurrencyReportType toCryptocurrencyReportType(CryptocurrencyReportTypeDto cryptocurrencyReportTypeDto);
}
