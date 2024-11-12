package com.example.JobProject.repository;

import com.example.JobProject.entity.PassportData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassportDataRepository extends JpaRepository<PassportData, Long> {
    PassportData findByPassportNumber(String passportNumber);
    List<PassportData> findByPassportCountry(String Country);
}
