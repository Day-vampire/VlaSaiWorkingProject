package com.example.JobProject.mapper;

import com.example.JobProject.dto.PassportDataDto;
import com.example.JobProject.entity.PassportData;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T19:12:00+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class PassportDataMapperImpl implements PassportDataMapper {

    @Override
    public PassportDataDto toPassportDataDto(PassportData passportData) {
        if ( passportData == null ) {
            return null;
        }

        PassportDataDto passportDataDto = new PassportDataDto();

        return passportDataDto;
    }

    @Override
    public PassportData toPassportData(PassportDataDto passportDataDto) {
        if ( passportDataDto == null ) {
            return null;
        }

        PassportData passportData = new PassportData();

        return passportData;
    }
}
