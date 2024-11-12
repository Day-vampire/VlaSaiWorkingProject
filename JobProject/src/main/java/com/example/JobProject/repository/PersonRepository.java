package com.example.JobProject.repository;

import com.example.JobProject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);
    Person findByEmail(String email);
}
