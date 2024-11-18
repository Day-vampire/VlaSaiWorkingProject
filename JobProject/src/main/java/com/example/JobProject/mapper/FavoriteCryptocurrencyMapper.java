package com.example.JobProject.mapper;

import com.example.JobProject.dto.FavoriteCryptocurrencyDto;
import com.example.JobProject.entity.FavoriteCryptocurrency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface FavoriteCryptocurrencyMapper {
    @Mapping(source = "user.id", target = "userId")
    FavoriteCryptocurrencyDto toFavoriteCryptocurrencyDto(FavoriteCryptocurrency favoriteCryptocurrency);
    FavoriteCryptocurrency toFavoriteCryptocurrency(FavoriteCryptocurrencyDto favoriteCryptocurrencyDto);
}
