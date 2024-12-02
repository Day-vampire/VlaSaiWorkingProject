package com.example.JobProject.service.impl;

import com.example.JobProject.dto.CashAccountDto;
import com.example.JobProject.entity.CashAccount;
import com.example.JobProject.mapper.CashAccountMapper;
import com.example.JobProject.repository.CashAccountRepository;
import com.example.JobProject.service.CashAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashAccountServiceImpl implements CashAccountService {
    private final CashAccountRepository cashAccountRepository;
    private final CashAccountMapper cashAccountMapper;

    @Override
    public CashAccountDto findByUserId(Long userId) {
        return cashAccountRepository
                .findByUserId(userId)
                .map(cashAccountMapper::toCashAccountDto)
                .orElse(null);
    }

    @Override
    public List<CashAccountDto> findByStatus(Boolean status) {
        return cashAccountRepository
                .findByStatus(status)
                .stream()
                .map(cashAccountMapper::toCashAccountDto)
                .toList();
    }

    @Override
    public List<CashAccountDto> findAll() {
        return cashAccountRepository
                .findAll()
                .stream()
                .map(cashAccountMapper::toCashAccountDto)
                .toList();
    }



    public void delete(Long userId) {
        cashAccountRepository.deleteById(userId);
    }
}
