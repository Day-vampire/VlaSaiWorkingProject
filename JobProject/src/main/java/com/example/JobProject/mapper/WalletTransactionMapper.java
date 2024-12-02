package com.example.JobProject.mapper;

import com.example.JobProject.dto.WalletTransactionDto;
import com.example.JobProject.entity.WalletTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WalletTransactionMapper {
    @Mapping(source = "cryptocurrencyWallet.id", target = "cryptocurrencyWalletId")
    WalletTransactionDto toWalletTransactionDto(WalletTransaction walletTransaction);
    WalletTransaction toWalletTransaction(WalletTransactionDto walletTransactionDto);
}
