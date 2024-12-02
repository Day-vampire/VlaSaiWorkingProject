package com.example.JobProject.mapper;

import com.example.JobProject.dto.AccountReportDto;
import com.example.JobProject.dto.CashAccountDto;
import com.example.JobProject.entity.AccountReport;
import com.example.JobProject.entity.CashAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AccountReportMapper {
    @Mappings({
        @Mapping(source = "cashAccount.id", target = "cashAccountId"),
        @Mapping(source = "accountReportType.id", target = "accountReportTypeId")})
    AccountReportDto toAccountReportDto(AccountReport accountReport);
    AccountReport toAccountReport(AccountReportDto accountReportDto);
}
