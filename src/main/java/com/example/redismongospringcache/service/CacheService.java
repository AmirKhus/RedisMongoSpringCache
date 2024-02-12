package com.example.redismongospringcache.service;

import com.example.redismongospringcache.model.CurrencyRate;

public interface CacheService {
    CurrencyRate put(CurrencyRate currencyRate);
}