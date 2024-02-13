package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * A class representing the body of JSON data received upon request from the exchange.
 */
@Data
public class MarketData {
    /**
     * List of data column names.
     */
    private List<String> columns;
    /**
     * List of market data.
     * Each list element contains a list of numbers of type BigDecimal,
     * representing market data for the corresponding columns.
     */
    private List<List<BigDecimal>> data;

    /**
* Converts a MarketData class object to a CurrencyPriceMaxAndMinDto object.
     * Returns a new CurrencyPriceMaxAndMinDto object containing
     * maximum and minimum prices from the market.
     *
     * @param marketData market data to convert
     * @return a CurrencyPriceMaxAndMinDto object containing the maximum and minimum price values
     */
    public static CurrencyPriceMaxAndMinDto getMoexDtoToCurrencyDto(MarketData marketData) {
        return new CurrencyPriceMaxAndMinDto().builder()
                .max(marketData.data.get(0).get(0))
                .min(marketData.data.get(0).get(1))
                .build();
    }
}
