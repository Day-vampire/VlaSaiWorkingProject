package com.example.JobProject.mapper;

import com.example.JobProject.dto.PersonDto;
import com.example.JobProject.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonMapper {
//    @Mapping(source = "passportData.id", target = "passportDataId")
    PersonDto toPersonDto(Person person);
    Person toPerson(PersonDto personDto);
}
