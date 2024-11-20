package com.example.JobProject.service.impl;

import com.example.JobProject.dto.PersonDto;
import com.example.JobProject.entity.Person;
import com.example.JobProject.mapper.PersonMapper;
import com.example.JobProject.repository.PassportDataRepository;
import com.example.JobProject.repository.PersonRepository;
import com.example.JobProject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PassportDataRepository passportDataRepository;
    private final PersonMapper personMapper;
    @Override
    public PersonDto findByName(String name) {
        return personRepository
                .findByName(name)
                .map(personMapper::toPersonDto)
                .orElse(null);
    }

    @Override
    public PersonDto findByEmail(String email) {
        return personRepository
                .findByEmail(email)
                .map(personMapper::toPersonDto)
                .orElse(null);
    }

    @Override
    public PersonDto findById(long id) {
        return personRepository
                .findById(id)
                .map(personMapper::toPersonDto)
                .orElse(null);
    }

//    @Override
//    public Person save(PersonDto personDto) {
//        Person person = Person
//                .builder()
//                .name(personDto.getName())
//                .surName(personDto.getSurName())
//                .email(personDto.getEmail())
//                .passportData(passportDataRepository.findById(personDto.getPassportDataId()))
//                .build();
//    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }
}
