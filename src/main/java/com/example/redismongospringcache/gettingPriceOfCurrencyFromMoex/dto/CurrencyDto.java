package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    private String name;
    private BigDecimal max;
    private BigDecimal min;
}
