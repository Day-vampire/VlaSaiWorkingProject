package com.example.JobProject.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CashAccountDto {
    private long id;
    private String currencyId;
    private BigDecimal balance;
    private boolean status;
    private Long userId;
}
