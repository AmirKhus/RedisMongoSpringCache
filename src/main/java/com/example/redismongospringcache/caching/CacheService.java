package com.example.redismongospringcache.caching;

import com.example.redismongospringcache.model.CurrencyRate;

public interface CacheService {
    CurrencyRate put(CurrencyRate currencyRate);
    void delete(String id);
}