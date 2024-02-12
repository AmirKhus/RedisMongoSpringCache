package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MarketData {
    private List<String> columns;
    private List<List<BigDecimal>> data;

    public static CurrencyDto getMoexDtoToCurrencyDto(MarketData marketData) {
        return new CurrencyDto().builder()
                .max(marketData.data.get(0).get(0))
                .min(marketData.data.get(0).get(1))
                .build();
    }
}
