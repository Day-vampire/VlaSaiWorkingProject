package com.example.JobProject.dto;

import lombok.Data;

@Data
public class FavoriteCryptocurrencyDto {
    private Long id;
    private String cryptocurrencyId;
    private Long userId;
}
