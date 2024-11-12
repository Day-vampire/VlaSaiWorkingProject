package com.example.JobProject.repository;

import com.example.JobProject.entity.AccountReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AccountReportRepository extends JpaRepository<AccountReport, Long> {

    List<AccountReport> findByCashAccountId(Long cashAccountId);
    List<AccountReport> findByReportTypeId(Long reportTypeId);
    List<AccountReport> findByCashAccountIdAndReportDate(Long cashAccountId, Date reportDate);
}
