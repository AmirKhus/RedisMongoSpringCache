package com.example.redismongospringcache.service;

import com.example.redismongospringcache.model.CurrencyRate;

import java.util.List;

public interface CurrencyRateService {
    CurrencyRate save(CurrencyRate currencyRate);

    List<CurrencyRate> getAll();

    CurrencyRate getByName(String currencyRateByName);

    void updatingDataInDBToTheParser(List<CurrencyRate> currency);
}
