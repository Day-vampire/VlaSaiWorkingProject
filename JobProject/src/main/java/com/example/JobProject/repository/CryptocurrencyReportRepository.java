package com.example.JobProject.repository;

import com.example.JobProject.entity.CryptocurrencyReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CryptocurrencyReportRepository extends JpaRepository<CryptocurrencyReport,Long> {
   List<CryptocurrencyReport> findByUserId(long userId);
   List<CryptocurrencyReport> findByCryptocurrencyReportTypeIdAndUserId(long cryptocurrencyReportTypeId, long userId);
   List<CryptocurrencyReport> findByCryptocurrencyIdAndUserId(String cryptocurrencyId, long userId);
   List<CryptocurrencyReport> findByReportDateAndUserId(Date reportDate, long userId);
   Optional<CryptocurrencyReport> findByReportNameAndUserId(String reportName, long userId);

}
