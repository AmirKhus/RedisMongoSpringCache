package com.example.redismongospringcache.service;

import com.example.redismongospringcache.model.CurrencyRate;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CurrencyRateService {
    CurrencyRate save(CurrencyRate currencyRate);

    List<CurrencyRate> getAll();

    CurrencyRate getByName(String currencyRateByName);

    CurrencyRate updatingDataInDBToTheParser(String currencyName);
}
