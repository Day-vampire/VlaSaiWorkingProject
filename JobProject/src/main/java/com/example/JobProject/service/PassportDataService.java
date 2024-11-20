package com.example.JobProject.service;

import com.example.JobProject.dto.PassportDataDto;
import com.example.JobProject.entity.PassportData;

import java.util.List;
import java.util.Optional;

public interface PassportDataService {
    Optional<PassportDataDto> findById(Long id);
    Optional<PassportDataDto> findByIdentificationNumber(String identificationNumber);
    List<PassportDataDto> findByCountry(String country);
}
