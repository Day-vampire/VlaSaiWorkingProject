package com.example.JobProject.mapper;

import com.example.JobProject.dto.AccountTransactionDto;
import com.example.JobProject.entity.AccountTransaction;
import com.example.JobProject.entity.CashAccount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T01:35:06+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AccountTransactionMapperImpl implements AccountTransactionMapper {

    @Override
    public AccountTransactionDto toAccountTransactionDto(AccountTransaction accountTransaction) {
        if ( accountTransaction == null ) {
            return null;
        }

        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();

        accountTransactionDto.setCashAccountId( accountTransactionCashAccountId( accountTransaction ) );
        accountTransactionDto.setId( accountTransaction.getId() );
        accountTransactionDto.setType( accountTransaction.getType() );
        accountTransactionDto.setCurrencyId( accountTransaction.getCurrencyId() );
        accountTransactionDto.setAmountOfCryptocurrency( accountTransaction.getAmountOfCryptocurrency() );
        accountTransactionDto.setCurrencyRate( accountTransaction.getCurrencyRate() );
        accountTransactionDto.setDateOfAccountTransaction( accountTransaction.getDateOfAccountTransaction() );

        return accountTransactionDto;
    }

    @Override
    public AccountTransaction toAccountTransaction(AccountTransactionDto accountTransactionDto) {
        if ( accountTransactionDto == null ) {
            return null;
        }

        AccountTransaction accountTransaction = new AccountTransaction();

        accountTransaction.setId( accountTransactionDto.getId() );
        accountTransaction.setType( accountTransactionDto.getType() );
        accountTransaction.setCurrencyId( accountTransactionDto.getCurrencyId() );
        accountTransaction.setAmountOfCryptocurrency( accountTransactionDto.getAmountOfCryptocurrency() );
        accountTransaction.setCurrencyRate( accountTransactionDto.getCurrencyRate() );
        accountTransaction.setDateOfAccountTransaction( accountTransactionDto.getDateOfAccountTransaction() );

        return accountTransaction;
    }

    private Long accountTransactionCashAccountId(AccountTransaction accountTransaction) {
        if ( accountTransaction == null ) {
            return null;
        }
        CashAccount cashAccount = accountTransaction.getCashAccount();
        if ( cashAccount == null ) {
            return null;
        }
        long id = cashAccount.getId();
        return id;
    }
}
