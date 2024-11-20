package com.example.JobProject.mapper;

import com.example.JobProject.dto.WalletTransactionDto;
import com.example.JobProject.entity.CryptocurrencyWallet;
import com.example.JobProject.entity.WalletTransaction;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T19:11:59+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class WalletTransactionMapperImpl implements WalletTransactionMapper {

    @Override
    public WalletTransactionDto toWalletTransactionDto(WalletTransaction walletTransaction) {
        if ( walletTransaction == null ) {
            return null;
        }

        WalletTransactionDto walletTransactionDto = new WalletTransactionDto();

        walletTransactionDto.setCryptocurrencyWalletId( walletTransactionCryptocurrencyWalletId( walletTransaction ) );
        walletTransactionDto.setId( walletTransaction.getId() );
        walletTransactionDto.setType( walletTransaction.getType() );
        walletTransactionDto.setCryptocurrencyId( walletTransaction.getCryptocurrencyId() );
        walletTransactionDto.setAmountOfCryptocurrency( walletTransaction.getAmountOfCryptocurrency() );
        walletTransactionDto.setCryptocurrencyRate( walletTransaction.getCryptocurrencyRate() );
        walletTransactionDto.setDateOfTransaction( walletTransaction.getDateOfTransaction() );

        return walletTransactionDto;
    }

    @Override
    public WalletTransaction toWalletTransaction(WalletTransactionDto walletTransactionDto) {
        if ( walletTransactionDto == null ) {
            return null;
        }

        WalletTransaction walletTransaction = new WalletTransaction();

        walletTransaction.setId( walletTransactionDto.getId() );
        walletTransaction.setType( walletTransactionDto.getType() );
        walletTransaction.setCryptocurrencyId( walletTransactionDto.getCryptocurrencyId() );
        walletTransaction.setAmountOfCryptocurrency( walletTransactionDto.getAmountOfCryptocurrency() );
        walletTransaction.setCryptocurrencyRate( walletTransactionDto.getCryptocurrencyRate() );
        walletTransaction.setDateOfTransaction( walletTransactionDto.getDateOfTransaction() );

        return walletTransaction;
    }

    private Long walletTransactionCryptocurrencyWalletId(WalletTransaction walletTransaction) {
        if ( walletTransaction == null ) {
            return null;
        }
        CryptocurrencyWallet cryptocurrencyWallet = walletTransaction.getCryptocurrencyWallet();
        if ( cryptocurrencyWallet == null ) {
            return null;
        }
        Long id = cryptocurrencyWallet.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
