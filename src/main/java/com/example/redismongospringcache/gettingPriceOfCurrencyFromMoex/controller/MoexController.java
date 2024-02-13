package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.controller;

import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyPriceMaxAndMinDto;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service.MoexService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * Controller for processing requests to obtain the maximum and minimum price of a currency
 */
@RestController
@Slf4j
@AllArgsConstructor
public class MoexController {
    @Autowired
    private  final MoexService moexService;
    /**
     * Obtaining the maximum and minimum price of a currency by its code.
     * @param currencyCod currency code.
     * @return a CurrencyPriceMaxAndMinDto object with information about the maximum and minimum price.
     */
    @GetMapping("/moex/{currencyCod}")
    public CurrencyPriceMaxAndMinDto getPriceCurrency(@PathVariable String currencyCod){
        log.info("GetMapping request '/getPriceCurrency' get list  Currency price max and min");
        return moexService.getCurrencyMinAndMaxPriceInfo(currencyCod);
    }
}
