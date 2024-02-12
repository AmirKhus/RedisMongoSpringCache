package com.example.redismongospringcache.caching;

import com.example.redismongospringcache.model.CurrencyRate;

public interface CachingService {
    CurrencyRate cachedUSD(CurrencyRate currencyRate);
    CurrencyRate cachedEUR(CurrencyRate currencyRate);
    CurrencyRate cachedGBP(CurrencyRate currencyRate);
    CurrencyRate cachedJPY(CurrencyRate currencyRate);
    CurrencyRate cachedAUD(CurrencyRate currencyRate);
    CurrencyRate cachedCAD(CurrencyRate currencyRate);
    CurrencyRate cachedCHF(CurrencyRate currencyRate);
    CurrencyRate cachedCNY(CurrencyRate currencyRate);
    CurrencyRate cachedSEK(CurrencyRate currencyRate);
    CurrencyRate cachedNZD(CurrencyRate currencyRate);
    CurrencyRate cachedSGD(CurrencyRate currencyRate);
    CurrencyRate cachedHKD(CurrencyRate currencyRate);
    CurrencyRate cachedNOK(CurrencyRate currencyRate);
    CurrencyRate cachedKRW(CurrencyRate currencyRate);
    CurrencyRate cachedTRY(CurrencyRate currencyRate);
    CurrencyRate cachedINR(CurrencyRate currencyRate);
    CurrencyRate cachedBRL(CurrencyRate currencyRate);
    CurrencyRate cachedZAR(CurrencyRate currencyRate);
}