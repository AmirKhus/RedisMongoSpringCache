package com.example.redismongospringcache.service;

import com.example.redismongospringcache.caching.CachingService;
import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.parser.service.CurrencyRateParserService;
import com.example.redismongospringcache.repository.CurrencyRateDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CurrencyRateServiceImpl implements CurrencyRateService {
    @Autowired
    private CurrencyRateDBRepository currencyRepository;
    @Autowired
    private CurrencyRateParserService currencyRateParserService;
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;
    @Autowired
    private CachingService cachingService;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public CurrencyRate save(CurrencyRate currencyRate) {
//        System.out.println(currencyRate);
//        System.out.println(template.opsForHash().values(currencyRate.getCharCode()));
        return cachedByValue(currencyRate);
    }

    @Override
    public List<CurrencyRate> getAll() {
        return currencyRepository.findAll();
    }

    @Override
    public CurrencyRate getByName(String currencyRateByName) {
        return currencyRepository.findByName(currencyRateByName) != null ? currencyRepository.findByName(currencyRateByName) : null;
    }

    @Override
//    @Cacheable(va)
    public CurrencyRate updatingDataInDBToTheParser(String currencyName) {
        CurrencyRate currencyRate = currencyRateParserService.getCurrencyRate(currencyName, LocalDate.now());
        return cachedByValue(currencyRate);
//        return currencyRepository.save(currencyRate);
    }

    public CurrencyRate cachedByValue(CurrencyRate currencyRate) {
        return switch (currencyRate.getCharCode()) {
            case "USD" -> cachingService.cachedUSD(currencyRate);
            case "EUR" -> cachingService.cachedEUR(currencyRate);
            case "GBP" -> cachingService.cachedGBP(currencyRate);
            case "JPY" -> cachingService.cachedJPY(currencyRate);
            case "AUD" -> cachingService.cachedAUD(currencyRate);
            case "CAD" -> cachingService.cachedCAD(currencyRate);
            case "CHF" -> cachingService.cachedCHF(currencyRate);
            case "CNY" -> cachingService.cachedCNY(currencyRate);
            case "SEK" -> cachingService.cachedSEK(currencyRate);
            case "NZD" -> cachingService.cachedNZD(currencyRate);
            case "SGD" -> cachingService.cachedSGD(currencyRate);
            case "HKD" -> cachingService.cachedHKD(currencyRate);
            case "NOK" -> cachingService.cachedNOK(currencyRate);
            case "KRW" -> cachingService.cachedKRW(currencyRate);
            case "TRY" -> cachingService.cachedTRY(currencyRate);
            case "INR" -> cachingService.cachedINR(currencyRate);
            case "BRL" -> cachingService.cachedBRL(currencyRate);
            case "ZAR" -> cachingService.cachedZAR(currencyRate);
            default -> throw new IllegalArgumentException("Unsupported currency: " + currencyRate.getCharCode());
        };
    }
}
