package com.example.JobProject.repository;

import com.example.JobProject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
    Optional<Person> findByEmail(String email);
    Optional<Person> findById(Long id);

    void delete(Long id);
}
