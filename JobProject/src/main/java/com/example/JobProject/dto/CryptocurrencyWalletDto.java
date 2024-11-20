package com.example.JobProject.dto;

import lombok.Data;

@Data
public class CryptocurrencyWalletDto {
    private Long id;
    private String currencyId;
    private boolean status;
    private boolean autoTradingStatus;
    private Long userId;
}
