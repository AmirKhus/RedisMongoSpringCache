package com.example.redismongospringcache.controller;

import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.scheduler.ScheduledService;
import com.example.redismongospringcache.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = "CurrencyRate")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;
    private final ScheduledService service;


    @PostMapping("/currencyRate")
    public CurrencyRate addNewCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        assert currencyRate != null : illegalArgumentException("CurrencyRate is null from addNewCurrencyRate()");
        log.info("PostMapping request '/currencyRate' with body current {}", currencyRate);
        return currencyRateService.save(currencyRate);
    }

    @GetMapping("/getCurrencyRates")
    @Cacheable()
    public List<CurrencyRate> getCurrencyRates() {
        log.info("GetMapping request '/getCurrencyRates' get list  Currency Rates");
        return currencyRateService.getAll();
    }

    @GetMapping("/getCurrencyRateByName/{id}")
    @Cacheable(key = "#id")
    public CurrencyRate getCurrencyRateByName(@PathVariable String id) {
        assert id != null : illegalArgumentException("CurrencyID is null from getCurrencyRateByName()");
        log.info("GetMapping request '/getCurrencyRateByName' get Currency Rates for name -> {}", id);
        return currencyRateService.getByName(id);
    }

    @RequestMapping(value = "/updateCurrencyRate", method = RequestMethod.PATCH)
    public ResponseEntity<HttpStatus> updateCurrencyRateAll() {
        log.info("PATH request");
        service.schedule();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCurrency(@PathVariable String id) {
        assert id != null : illegalArgumentException("CurrencyID is null from clearCacheCurrency()");
        log.info("delete currency from key = " + id);
        currencyRateService.delete(id);
    }

    private IllegalArgumentException illegalArgumentException(String message){
        log.error(message);
        throw new IllegalArgumentException(message);
    }
}