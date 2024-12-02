package com.example.JobProject.repository;

import com.example.JobProject.entity.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CashAccountRepository extends JpaRepository<CashAccount,Long> {
    Optional<CashAccount> findByUserId(Long userId);
    List <CashAccount> findByStatus(Boolean status);
    List<CashAccount> findAll();
}
