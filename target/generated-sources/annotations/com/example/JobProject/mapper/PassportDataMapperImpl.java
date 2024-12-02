package com.example.JobProject.mapper;

import com.example.JobProject.dto.PassportDataDto;
import com.example.JobProject.entity.PassportData;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T01:36:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PassportDataMapperImpl implements PassportDataMapper {

    @Override
    public PassportDataDto toPassportDataDto(PassportData passportData) {
        if ( passportData == null ) {
            return null;
        }

        PassportDataDto passportDataDto = new PassportDataDto();

        passportDataDto.setId( passportData.getId() );
        passportDataDto.setDateOfIssue( passportData.getDateOfIssue() );
        passportDataDto.setValidityPeriod( passportData.getValidityPeriod() );
        passportDataDto.setIdentificationNumber( passportData.getIdentificationNumber() );
        passportDataDto.setCountry( passportData.getCountry() );

        return passportDataDto;
    }

    @Override
    public PassportData toPassportData(PassportDataDto passportDataDto) {
        if ( passportDataDto == null ) {
            return null;
        }

        PassportData.PassportDataBuilder passportData = PassportData.builder();

        passportData.id( passportDataDto.getId() );
        passportData.dateOfIssue( passportDataDto.getDateOfIssue() );
        passportData.validityPeriod( passportDataDto.getValidityPeriod() );
        passportData.identificationNumber( passportDataDto.getIdentificationNumber() );
        passportData.country( passportDataDto.getCountry() );

        return passportData.build();
    }
}
