package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service;

import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyPriceMaxAndMinDto;

public interface MoexService {

    CurrencyPriceMaxAndMinDto getCurrencyMinAndMaxPriceInfo(String currencyCod);

}
