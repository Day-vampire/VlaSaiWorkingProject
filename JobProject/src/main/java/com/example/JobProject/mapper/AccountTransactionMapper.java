package com.example.JobProject.mapper;

import com.example.JobProject.dto.AccountTransactionDto;
import com.example.JobProject.entity.AccountTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountTransactionMapper {
    @Mapping(source = "cashAccount.id", target = "cashAccountId")
AccountTransactionDto toAccountTransactionDto(AccountTransaction accountTransaction);
    AccountTransaction toAccountTransaction(AccountTransactionDto accountTransactionDto);
}
