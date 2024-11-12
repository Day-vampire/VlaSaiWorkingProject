package com.example.JobProject.repository;

import com.example.JobProject.entity.CryptocurrencyReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CryptocurrencyReportRepository extends JpaRepository<CryptocurrencyReport,Long> {
   List<CryptocurrencyReport> findByUserId(long userId);
   List<CryptocurrencyReport> findByReportTypeIdAndUSerID(long reportTypeId, long userId);
   List<CryptocurrencyReport> findByCryptocurrencyIdAndUserId(String cryptocurrencyId, long userId);
   List<CryptocurrencyReport> findByReportDateAndUserId(Date reportDate, long userId);
   CryptocurrencyReport findByReportNameAndUserId(String reportName, long userId);

}
