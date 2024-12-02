package com.example.JobProject.service;


import com.example.JobProject.dto.CashAccountDto;
import com.example.JobProject.entity.CashAccount;

import java.util.List;

public interface CashAccountService {
    CashAccountDto findByUserId(Long userId);
    List<CashAccountDto> findByStatus(Boolean status);
    List<CashAccountDto> findAll();
}
