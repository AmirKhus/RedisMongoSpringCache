package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service;

import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyPriceMaxAndMinDto;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencySecID;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.MoexDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.MarketData.getMoexDtoToCurrencyDto;

/**
* Implementation of a service for obtaining the maximum and minimum prices of currencies from the MOEX exchange.
 */
@Service
public class MoexServiceImpl implements MoexService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${parse.moex.url}")
    private String moexParseUrl;
/**
     * Gets the maximum and minimum prices of a currency from the MOEX exchange by its code.
     *
     * @param currencyCod currency code
     * @return a CurrencyPriceMaxAndMinDto object with the maximum and minimum prices of the currency
     */
    @Override
    public CurrencyPriceMaxAndMinDto getCurrencyMinAndMaxPriceInfo(String currencyCod) {
        CurrencySecID currencySecID = CurrencySecID.valueOf(currencyCod);
        String parseUrl = moexParseUrl.replace("SECID", currencySecID.getSecID());
        MoexDto moexDto = restTemplate.getForEntity(parseUrl,MoexDto.class).getBody();

        CurrencyPriceMaxAndMinDto currencyPriceMaxAndMinDto = getMoexDtoToCurrencyDto(moexDto.getMarketdata());
        currencyPriceMaxAndMinDto.setName(currencyCod);
        return currencyPriceMaxAndMinDto;
    }
}
