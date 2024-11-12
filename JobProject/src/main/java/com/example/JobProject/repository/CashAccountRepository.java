package com.example.JobProject.repository;

import com.example.JobProject.entity.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashAccountRepository extends JpaRepository<CashAccount,Long> {
    CashAccount findByUserId(Long UserId);
    List <CashAccount> findByStatus(Boolean status);
    List<CashAccount> findAll();
}
