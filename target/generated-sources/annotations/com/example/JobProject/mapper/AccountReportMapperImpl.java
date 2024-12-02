package com.example.JobProject.mapper;

import com.example.JobProject.dto.AccountReportDto;
import com.example.JobProject.entity.AccountReport;
import com.example.JobProject.entity.AccountReportType;
import com.example.JobProject.entity.CashAccount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T01:33:33+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AccountReportMapperImpl implements AccountReportMapper {

    @Override
    public AccountReportDto toAccountReportDto(AccountReport accountReport) {
        if ( accountReport == null ) {
            return null;
        }

        AccountReportDto accountReportDto = new AccountReportDto();

        accountReportDto.setCashAccountId( accountReportCashAccountId( accountReport ) );
        accountReportDto.setAccountReportTypeId( accountReportAccountReportTypeId( accountReport ) );
        accountReportDto.setId( accountReport.getId() );
        accountReportDto.setReportName( accountReport.getReportName() );
        accountReportDto.setReportDate( accountReport.getReportDate() );

        return accountReportDto;
    }

    @Override
    public AccountReport toAccountReport(AccountReportDto accountReportDto) {
        if ( accountReportDto == null ) {
            return null;
        }

        AccountReport.AccountReportBuilder accountReport = AccountReport.builder();

        accountReport.id( accountReportDto.getId() );
        accountReport.reportName( accountReportDto.getReportName() );
        accountReport.reportDate( accountReportDto.getReportDate() );

        return accountReport.build();
    }

    private Long accountReportCashAccountId(AccountReport accountReport) {
        if ( accountReport == null ) {
            return null;
        }
        CashAccount cashAccount = accountReport.getCashAccount();
        if ( cashAccount == null ) {
            return null;
        }
        long id = cashAccount.getId();
        return id;
    }

    private Long accountReportAccountReportTypeId(AccountReport accountReport) {
        if ( accountReport == null ) {
            return null;
        }
        AccountReportType accountReportType = accountReport.getAccountReportType();
        if ( accountReportType == null ) {
            return null;
        }
        long id = accountReportType.getId();
        return id;
    }
}
