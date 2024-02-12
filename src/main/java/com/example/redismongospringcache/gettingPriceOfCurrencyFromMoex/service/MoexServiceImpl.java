package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service;

import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyDto;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencySecID;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.MoexDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.MarketData.getMoexDtoToCurrencyDto;

@Service
@AllArgsConstructor
public class MoexServiceImpl implements MoexService {
    private final RestTemplate restTemplate;
    @Override
    public CurrencyDto getCurrencyMinAndMaxPriceInfo(String currencyCod) {
        CurrencySecID currencySecID = CurrencySecID.valueOf(currencyCod);
        MoexDto moexDto = restTemplate.getForEntity("https://iss.moex.com/iss/engines/currency/markets/selt/boards/CETS/securities/"+currencySecID.getSecID()+".json?callback=iss_jsonp_82f90a84d69b82afd6e3ab0d0e646fb787b807ce&iss.meta=off&iss.only=marketdata&lang=ru&_=1707755720505&marketdata.columns=HIGH,LOW&iss.colum=off",MoexDto.class).getBody();

        CurrencyDto currencyDto = getMoexDtoToCurrencyDto(moexDto.getMarketdata());
        currencyDto.setName(currencyCod);
        return currencyDto;
    }
}
