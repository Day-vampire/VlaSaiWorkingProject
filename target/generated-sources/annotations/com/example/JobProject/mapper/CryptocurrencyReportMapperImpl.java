package com.example.JobProject.mapper;

import com.example.JobProject.dto.CryptocurrencyReportDto;
import com.example.JobProject.entity.CryptocurrencyReport;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T19:11:59+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class CryptocurrencyReportMapperImpl implements CryptocurrencyReportMapper {

    @Override
    public CryptocurrencyReportDto toCryptocurrencyReportDto(CryptocurrencyReport cryptocurrencyReport) {
        if ( cryptocurrencyReport == null ) {
            return null;
        }

        CryptocurrencyReportDto cryptocurrencyReportDto = new CryptocurrencyReportDto();

        cryptocurrencyReportDto.setId( cryptocurrencyReport.getId() );
        cryptocurrencyReportDto.setReportName( cryptocurrencyReport.getReportName() );
        cryptocurrencyReportDto.setReportDate( cryptocurrencyReport.getReportDate() );
        cryptocurrencyReportDto.setCryptocurrencyId( cryptocurrencyReport.getCryptocurrencyId() );

        return cryptocurrencyReportDto;
    }

    @Override
    public CryptocurrencyReport toCryptocurrencyReport(CryptocurrencyReportDto cryptocurrencyReportDto) {
        if ( cryptocurrencyReportDto == null ) {
            return null;
        }

        CryptocurrencyReport cryptocurrencyReport = new CryptocurrencyReport();

        cryptocurrencyReport.setId( cryptocurrencyReportDto.getId() );
        cryptocurrencyReport.setReportName( cryptocurrencyReportDto.getReportName() );
        cryptocurrencyReport.setReportDate( cryptocurrencyReportDto.getReportDate() );
        cryptocurrencyReport.setCryptocurrencyId( cryptocurrencyReportDto.getCryptocurrencyId() );

        return cryptocurrencyReport;
    }
}
