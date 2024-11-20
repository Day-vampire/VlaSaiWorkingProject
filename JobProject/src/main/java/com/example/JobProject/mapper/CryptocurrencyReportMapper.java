package com.example.JobProject.mapper;

import com.example.JobProject.dto.CryptocurrencyReportDto;
import com.example.JobProject.entity.CryptocurrencyReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CryptocurrencyReportMapper {

//    @Mappings({
//            @Mapping(source = "cryptocurrencyReportType.id", target = "cryptocurrencyReportTypeId"),
//            @Mapping(source = "user.id", target = "userId"),
//    })
    CryptocurrencyReportDto toCryptocurrencyReportDto(CryptocurrencyReport cryptocurrencyReport);
    CryptocurrencyReport toCryptocurrencyReport(CryptocurrencyReportDto cryptocurrencyReportDto);
}
