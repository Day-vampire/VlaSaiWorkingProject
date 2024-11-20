package com.example.JobProject.mapper;

import com.example.JobProject.dto.CryptocurrencyReportTypeDto;
import com.example.JobProject.entity.CryptocurrencyReportType;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T19:11:59+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class CryptocurrencyReportTypeMapperImpl implements CryptocurrencyReportTypeMapper {

    @Override
    public CryptocurrencyReportTypeDto toCryptocurrencyReportTypeDto(CryptocurrencyReportType cryptocurrencyReportType) {
        if ( cryptocurrencyReportType == null ) {
            return null;
        }

        CryptocurrencyReportTypeDto cryptocurrencyReportTypeDto = new CryptocurrencyReportTypeDto();

        return cryptocurrencyReportTypeDto;
    }

    @Override
    public CryptocurrencyReportType toCryptocurrencyReportType(CryptocurrencyReportTypeDto cryptocurrencyReportTypeDto) {
        if ( cryptocurrencyReportTypeDto == null ) {
            return null;
        }

        CryptocurrencyReportType cryptocurrencyReportType = new CryptocurrencyReportType();

        return cryptocurrencyReportType;
    }
}
