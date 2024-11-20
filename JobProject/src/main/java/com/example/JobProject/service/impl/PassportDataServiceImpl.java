package com.example.JobProject.service.impl;

import com.example.JobProject.dto.PassportDataDto;
import com.example.JobProject.dto.RoleDto;
import com.example.JobProject.entity.PassportData;
import com.example.JobProject.entity.Role;
import com.example.JobProject.mapper.PassportDataMapper;
import com.example.JobProject.repository.PassportDataRepository;
import com.example.JobProject.service.PassportDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassportDataServiceImpl implements PassportDataService {

    private final PassportDataRepository passportDataRepository;
    private final PassportDataMapper passportDataMapper;

    @Override
    public Optional<PassportDataDto> findById(Long id) {
        return passportDataRepository.findById(id).map(passportDataMapper::toPassportDataDto);
    }

    @Override
    public Optional<PassportDataDto> findByIdentificationNumber(String identificationNumber) {
        return passportDataRepository.
                findByIdentificationNumber(identificationNumber).
                map(passportDataMapper::toPassportDataDto);
    }

    @Override
    public List<PassportDataDto> findByCountry(String country) {
        return passportDataRepository.findByCountry(country)
                .stream()
                .map(passportDataMapper::toPassportDataDto)
                .toList();
    }

    public List<PassportDataDto> findAll() {
        return passportDataRepository.
                findAll().
                stream().
                map(passportDataMapper::toPassportDataDto).
                toList();
    }

    public PassportData passportData(PassportDataDto passportDataDto) {
        PassportData passportData = PassportData
                .builder().dateOfIssue(passportDataDto.getDateOfIssue())
                .validityPeriod(passportDataDto.getValidityPeriod())
                .identificationNumber(passportDataDto.getIdentificationNumber())
                .country(passportDataDto.getCountry())
                .build();
        return passportDataRepository.save(passportData);
    }

    public void delete(Long id) {
        passportDataRepository.deleteById(id);
    }
}
