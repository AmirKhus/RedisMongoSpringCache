package com.example.redismongospringcache.parser.service;


import com.example.redismongospringcache.model.CurrencyRate;

import java.time.LocalDate;

public interface CurrencyRateParserService {
    String getRatesAsXml(String url);
    CurrencyRate getCurrencyRate(String currency, LocalDate date);
}
