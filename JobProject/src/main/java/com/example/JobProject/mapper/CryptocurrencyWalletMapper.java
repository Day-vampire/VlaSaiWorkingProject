package com.example.JobProject.mapper;

import com.example.JobProject.dto.CryptocurrencyWalletDto;
import com.example.JobProject.entity.CryptocurrencyWallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CryptocurrencyWalletMapper {
    @Mapping(source = "user.id", target="userId")
    CryptocurrencyWalletDto toCryptocurrencyWalletDto(CryptocurrencyWallet cryptocurrencyWallet);
    CryptocurrencyWallet toCryptocurrencyWallet(CryptocurrencyWalletDto cryptocurrencyWalletDto);
}
