package com.example.redismongospringcache.controller;

import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.service.CurrencyRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CurrencyRateController {
    @Autowired
    CurrencyRateService currencyRateService;

    @PostMapping("/currencyRate")
    @Cacheable(value = "currencyRate", key = "#currencyRate.charCode")
    public CurrencyRate addNewCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        log.info("PostMapping request '/currencyRate' with body current {}", currencyRate);
        return currencyRateService.save(currencyRate);
    }

    @GetMapping("/getCurrencyRates")
    public List<CurrencyRate> getCurrencyRates(){
        log.info("GetMapping request '/getCurrencyRates' get list  Currency Rates");
        return  currencyRateService.getAll();
    }

    @GetMapping("/getCurrencyRateByName")
    @Cacheable(value = "currencyRate", key = "#name")
    public CurrencyRate getCurrencyRateByName(@RequestParam String name){
        log.info("GetMapping request '/getCurrencyRateByName' get Currency Rates for name -> {}",name);
        return currencyRateService.getByName(name);
    }

    @PutMapping("/updateCurrencyRate")
    @Cacheable  (value = "currencyRate", key = "#currencyRate.charCode")
    public CurrencyRate updateCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        log.info("GetMapping request '/updateCurrencyRate'  with body -> {}",currencyRate);
        return  currencyRateService.save(currencyRate);
    }
}