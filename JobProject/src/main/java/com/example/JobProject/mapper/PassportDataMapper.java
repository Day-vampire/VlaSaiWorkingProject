package com.example.JobProject.mapper;

import com.example.JobProject.dto.PassportDataDto;
import com.example.JobProject.entity.PassportData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PassportDataMapper {

    PassportDataDto toPassportDataDto(PassportData passportData);
    PassportData toPassportData(PassportDataDto passportDataDto);
}
