package com.example.JobProject.mapper;

import com.example.JobProject.dto.CryptocurrencyWalletDto;
import com.example.JobProject.entity.CryptocurrencyWallet;
import com.example.JobProject.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T18:39:19+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CryptocurrencyWalletMapperImpl implements CryptocurrencyWalletMapper {

    @Override
    public CryptocurrencyWalletDto toCryptocurrencyWalletDto(CryptocurrencyWallet cryptocurrencyWallet) {
        if ( cryptocurrencyWallet == null ) {
            return null;
        }

        CryptocurrencyWalletDto cryptocurrencyWalletDto = new CryptocurrencyWalletDto();

        cryptocurrencyWalletDto.setUserId( cryptocurrencyWalletUserId( cryptocurrencyWallet ) );
        cryptocurrencyWalletDto.setId( cryptocurrencyWallet.getId() );
        cryptocurrencyWalletDto.setCurrencyId( cryptocurrencyWallet.getCurrencyId() );
        cryptocurrencyWalletDto.setStatus( cryptocurrencyWallet.isStatus() );
        cryptocurrencyWalletDto.setAutoTradingStatus( cryptocurrencyWallet.isAutoTradingStatus() );

        return cryptocurrencyWalletDto;
    }

    @Override
    public CryptocurrencyWallet toCryptocurrencyWallet(CryptocurrencyWalletDto cryptocurrencyWalletDto) {
        if ( cryptocurrencyWalletDto == null ) {
            return null;
        }

        CryptocurrencyWallet cryptocurrencyWallet = new CryptocurrencyWallet();

        cryptocurrencyWallet.setId( cryptocurrencyWalletDto.getId() );
        cryptocurrencyWallet.setCurrencyId( cryptocurrencyWalletDto.getCurrencyId() );
        cryptocurrencyWallet.setStatus( cryptocurrencyWalletDto.isStatus() );
        cryptocurrencyWallet.setAutoTradingStatus( cryptocurrencyWalletDto.isAutoTradingStatus() );

        return cryptocurrencyWallet;
    }

    private Long cryptocurrencyWalletUserId(CryptocurrencyWallet cryptocurrencyWallet) {
        if ( cryptocurrencyWallet == null ) {
            return null;
        }
        User user = cryptocurrencyWallet.getUser();
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
