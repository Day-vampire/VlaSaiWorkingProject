package com.example.JobProject.mapper;

import com.example.JobProject.dto.FavoriteCryptocurrencyDto;
import com.example.JobProject.entity.FavoriteCryptocurrency;
import com.example.JobProject.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T19:11:59+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class FavoriteCryptocurrencyMapperImpl implements FavoriteCryptocurrencyMapper {

    @Override
    public FavoriteCryptocurrencyDto toFavoriteCryptocurrencyDto(FavoriteCryptocurrency favoriteCryptocurrency) {
        if ( favoriteCryptocurrency == null ) {
            return null;
        }

        FavoriteCryptocurrencyDto favoriteCryptocurrencyDto = new FavoriteCryptocurrencyDto();

        favoriteCryptocurrencyDto.setUserId( favoriteCryptocurrencyUserId( favoriteCryptocurrency ) );
        favoriteCryptocurrencyDto.setId( favoriteCryptocurrency.getId() );
        favoriteCryptocurrencyDto.setCryptocurrencyId( favoriteCryptocurrency.getCryptocurrencyId() );

        return favoriteCryptocurrencyDto;
    }

    @Override
    public FavoriteCryptocurrency toFavoriteCryptocurrency(FavoriteCryptocurrencyDto favoriteCryptocurrencyDto) {
        if ( favoriteCryptocurrencyDto == null ) {
            return null;
        }

        FavoriteCryptocurrency favoriteCryptocurrency = new FavoriteCryptocurrency();

        favoriteCryptocurrency.setId( favoriteCryptocurrencyDto.getId() );
        favoriteCryptocurrency.setCryptocurrencyId( favoriteCryptocurrencyDto.getCryptocurrencyId() );

        return favoriteCryptocurrency;
    }

    private Long favoriteCryptocurrencyUserId(FavoriteCryptocurrency favoriteCryptocurrency) {
        if ( favoriteCryptocurrency == null ) {
            return null;
        }
        User user = favoriteCryptocurrency.getUser();
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
