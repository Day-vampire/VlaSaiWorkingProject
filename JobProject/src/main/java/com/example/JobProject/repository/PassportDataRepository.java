package com.example.JobProject.repository;

import com.example.JobProject.entity.PassportData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PassportDataRepository extends JpaRepository<PassportData, Long> {
    @Override
    Optional<PassportData> findById(Long id);

    Optional<PassportData> findByIdentificationNumber(String identificationNumber);
    List<PassportData> findByCountry(String country);
}
