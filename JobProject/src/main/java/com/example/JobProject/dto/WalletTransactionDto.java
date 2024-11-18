package com.example.JobProject.dto;

import java.math.BigDecimal;
import java.util.Date;

public class WalletTransactionDto {
    private long id;
    private String type;
    private String cryptocurrencyId;
    private BigDecimal amountOfCryptocurrency;
    private BigDecimal cryptocurrencyRate;
    private Date dateOfTransaction;
    private Long cryptocurrencyWalletId;
}
