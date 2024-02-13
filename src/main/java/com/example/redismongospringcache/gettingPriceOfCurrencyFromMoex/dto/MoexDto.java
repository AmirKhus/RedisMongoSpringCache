package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.Data;
/**
 * A class representing the body of JSON data received upon request from the exchange.
 */
@Data
public class MoexDto {
    private MarketData marketdata;
}
