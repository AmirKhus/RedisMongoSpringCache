package com.example.redismongospringcache.controller;

import com.example.redismongospringcache.model.CurrencyEnum;
import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.repository.CurrencyRateDBRepository;
import com.example.redismongospringcache.service.CurrencyRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class CurrencyRateController {
    @Autowired
    CurrencyRateService currencyRateService;

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    RedisTemplate redisTemplate;
    @PostMapping("/currencyRate")
    public CurrencyRate addNewCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        log.info("PostMapping request '/currencyRate' with body current {}", currencyRate);
        applicationContext.getBean("cacheManager");
        return currencyRateService.save(currencyRate);
    }

    @GetMapping("/getCurrencyRates")
    public List<CurrencyRate> getCurrencyRates(){
        log.info("GetMapping request '/getCurrencyRates' get list  Currency Rates");
        return  currencyRateService.getAll();
    }

    @GetMapping("/getCurrencyRateByName")
    @Cacheable(value = "CurrencyRate", key = "#name")
    public CurrencyRate getCurrencyRateByName(@RequestParam String name){
        log.info("GetMapping request '/getCurrencyRateByName' get Currency Rates for name -> {}",name);
        return currencyRateService.getByName(name);
    }
    @PutMapping("/updateCurrencyRate")
    @Cacheable(value = "CurrencyRate", key = "#currencyRate.charCode")
    public CurrencyRate updateCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        log.info("GetMapping request '/updateCurrencyRate'  with body -> {}",currencyRate);
        applicationContext.getBean("cacheManager");
        return  currencyRateService.save(currencyRate);
    }
    @CacheEvict(cacheNames = "USD")
    @GetMapping("/clear")
    public void clearCache() {
        log.info("clear cache");
//        List<String> currency = Arrays.stream(CurrencyEnum.values())
//                .map(Enum::name)
//                .collect(Collectors.toList());
//        for (String currencyName : currency) {
//            Objects.requireNonNull(cacheManager.getCache(currencyName)).clear();
//        }
    }
}