package com.example.redismongospringcache.controller;

import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = "CurrencyRate")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    private final ApplicationContext applicationContext;


    @PostMapping("/currencyRate")
    public CurrencyRate addNewCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        log.info("PostMapping request '/currencyRate' with body current {}", currencyRate);
        return currencyRateService.save(currencyRate);
    }

    @GetMapping("/getCurrencyRates")
    @Cacheable()
    public List<CurrencyRate> getCurrencyRates() {
        log.info("GetMapping request '/getCurrencyRates' get list  Currency Rates");
        return currencyRateService.getAll();
    }

    @GetMapping("/getCurrencyRateByName")
    @Cacheable(key = "#name")
    public CurrencyRate getCurrencyRateByName(@RequestParam String name) {
        log.info("GetMapping request '/getCurrencyRateByName' get Currency Rates for name -> {}", name);
        return currencyRateService.getByName(name);
    }

    @PutMapping("/updateCurrencyRate")
    @Cacheable(key = "#currencyRate.charCode")
    public CurrencyRate updateCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        log.info("GetMapping request '/updateCurrencyRate'  with body -> {}", currencyRate);
        applicationContext.getBean("cacheManager");
        return currencyRateService.save(currencyRate);
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