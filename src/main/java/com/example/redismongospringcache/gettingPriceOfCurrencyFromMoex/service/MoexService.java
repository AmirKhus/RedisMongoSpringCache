package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service;

import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyDto;

public interface MoexService {

    CurrencyDto getCurrencyMinAndMaxPriceInfo(String currencyCod);

}
