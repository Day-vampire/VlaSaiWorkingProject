package com.example.JobProject.mapper;

import com.example.JobProject.dto.CashAccountDto;
import com.example.JobProject.entity.CashAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CashAccountMapper {
    @Mapping(source ="user.id", target = "userId")
    CashAccountDto toCashAccountDto(CashAccount cashAccount);
    CashAccount toCashAccount(CashAccountDto cashAccountDto);
}
