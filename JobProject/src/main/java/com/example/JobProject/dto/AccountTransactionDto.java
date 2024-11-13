package com.example.JobProject.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AccountTransactionDto {
    private Long id;
    private String type;
    private String currencyId;
    private BigDecimal amountOfCryptocurrency;
    private BigDecimal currencyRate;
    private Date dateOfAccountTransaction;
    private Long cashAccountId;
}
