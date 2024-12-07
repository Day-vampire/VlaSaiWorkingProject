package com.example.JobProject.mapper;

import com.example.JobProject.dto.PersonDto;
import com.example.JobProject.entity.Person;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T18:39:19+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDto toPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( person.getId() );
        personDto.setName( person.getName() );
        personDto.setSurName( person.getSurName() );
        personDto.setEmail( person.getEmail() );

        return personDto;
    }

    @Override
    public Person toPerson(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        person.id( personDto.getId() );
        person.name( personDto.getName() );
        person.surName( personDto.getSurName() );
        person.email( personDto.getEmail() );

        return person.build();
    }
}
