package com.example.redismongospringcache.caching;

import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.repository.CurrencyRateDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CachingServiceImpl implements CachingService {

    @Autowired
    private CurrencyRateDBRepository currencyRateDBRepository;
    

    @Override
    @Cacheable(value = "USD", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedUSD(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "EUR", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedEUR(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "GBP", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedGBP(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "JPY", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedJPY(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "AUD", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedAUD(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "CAD", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedCAD(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "CHF", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedCHF(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "CNY", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedCNY(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "SEK", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedSEK(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "NZD", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedNZD(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "SGD", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedSGD(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "HKD", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedHKD(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "NOK", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedNOK(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "KRW", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedKRW(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "TRY", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedTRY(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "INR", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedINR(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "BRL", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedBRL(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }

    @Override
    @Cacheable(value = "ZAR", key = "#currencyRate.getCharCode()")
    public CurrencyRate cachedZAR(CurrencyRate currencyRate) {
        currencyRateDBRepository.save(currencyRate);
        return currencyRate;
    }
}