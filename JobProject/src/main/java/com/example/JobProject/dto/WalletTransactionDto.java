package com.example.JobProject.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class WalletTransactionDto {
    private long id;
    private String type;
    private String cryptocurrencyId;
    private BigDecimal amountOfCryptocurrency;
    private BigDecimal cryptocurrencyRate;
    private Date dateOfTransaction;
    private Long cryptocurrencyWalletId;
}
