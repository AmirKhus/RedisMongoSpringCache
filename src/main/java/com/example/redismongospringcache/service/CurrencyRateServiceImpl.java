package com.example.redismongospringcache.service;

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
    public static final String HASH_KEY = "CurrencyRate";

    @Override
    public CurrencyRate save(CurrencyRate currencyRate) {
        template.opsForHash().put(HASH_KEY, currencyRate.getName(), currencyRate);
        return currencyRepository.save(currencyRate);
    }

    @Override
    public List<CurrencyRate> getAll() {
        template.opsForHash().values(HASH_KEY);
        return currencyRepository.findAll();
    }

    @Override
    public CurrencyRate getByName(String currencyRateByName) {
        template.opsForHash().get(HASH_KEY, currencyRateByName);
        return currencyRepository.findByName(currencyRateByName) != null ? currencyRepository.findByName(currencyRateByName) : null;
    }

    @Override
    @Cacheable(value = "currencyRate", key = "#currencyName")
    public CurrencyRate updatingDataInDBToTheParser(String currencyName) {
        CurrencyRate currencyRate = currencyRateParserService.getCurrencyRate(currencyName, LocalDate.now());
        template.opsForHash().put(HASH_KEY, currencyRate.getCharCode(), currencyRate);
        return currencyRepository.save(currencyRate);
    }
}
