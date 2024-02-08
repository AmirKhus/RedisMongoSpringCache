package com.example.redismongospringcache.parser.parser;


import com.example.redismongospringcache.model.CurrencyRate;

import java.util.List;

public interface CurrencyRateParser {
    List<CurrencyRate> parse(String ratesAsString);
}
