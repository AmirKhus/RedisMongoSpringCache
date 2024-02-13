package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO to represent the maximum and minimum prices of a currency.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPriceMaxAndMinDto {
    /**
     * Name of the currency.
     */
    private String name;

    /**
     * Maximum price.
     */
    private BigDecimal max;

    /**
     * Minimum price.
     */
    private BigDecimal min;
}