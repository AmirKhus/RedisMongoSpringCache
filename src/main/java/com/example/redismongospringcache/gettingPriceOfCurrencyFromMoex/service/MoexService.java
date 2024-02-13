package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service;

import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyPriceMaxAndMinDto;
/**
 * Service interface for obtaining the maximum and minimum prices of a currency from the MOEX exchange.
 */
public interface MoexService {
/**
     * Gets the maximum and minimum prices of a currency from the MOEX exchange by its code.
     *
     * @param currencyCod currency code
     * @return a CurrencyPriceMaxAndMinDto object with the maximum and minimum prices of the currency
     */
    CurrencyPriceMaxAndMinDto getCurrencyMinAndMaxPriceInfo(String currencyCod);

}
