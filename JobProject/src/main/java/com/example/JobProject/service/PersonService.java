package com.example.JobProject.service;

import com.example.JobProject.dto.PersonDto;
import com.example.JobProject.entity.Person;

public interface PersonService {
    PersonDto findByName(String name);
    PersonDto findByEmail(String email);
    PersonDto findById(long id);
//    Person save(PersonDto personDto);
    void delete(Long personDto);
}
