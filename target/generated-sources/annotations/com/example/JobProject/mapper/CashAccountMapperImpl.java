package com.example.JobProject.mapper;

import com.example.JobProject.dto.CashAccountDto;
import com.example.JobProject.entity.CashAccount;
import com.example.JobProject.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T01:34:14+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CashAccountMapperImpl implements CashAccountMapper {

    @Override
    public CashAccountDto toCashAccountDto(CashAccount cashAccount) {
        if ( cashAccount == null ) {
            return null;
        }

        CashAccountDto cashAccountDto = new CashAccountDto();

        cashAccountDto.setUserId( cashAccountUserId( cashAccount ) );
        cashAccountDto.setId( cashAccount.getId() );
        cashAccountDto.setCurrencyId( cashAccount.getCurrencyId() );
        cashAccountDto.setBalance( cashAccount.getBalance() );
        cashAccountDto.setStatus( cashAccount.isStatus() );

        return cashAccountDto;
    }

    @Override
    public CashAccount toCashAccount(CashAccountDto cashAccountDto) {
        if ( cashAccountDto == null ) {
            return null;
        }

        CashAccount cashAccount = new CashAccount();

        cashAccount.setId( cashAccountDto.getId() );
        cashAccount.setCurrencyId( cashAccountDto.getCurrencyId() );
        cashAccount.setBalance( cashAccountDto.getBalance() );
        cashAccount.setStatus( cashAccountDto.isStatus() );

        return cashAccount;
    }

    private Long cashAccountUserId(CashAccount cashAccount) {
        if ( cashAccount == null ) {
            return null;
        }
        User user = cashAccount.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
