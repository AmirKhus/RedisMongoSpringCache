package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.controller;

import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyDto;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.MoexDto;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service.MoexService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MoexController {
    @Autowired
    private  final MoexService moexService;
    @GetMapping("/moex/{currencyCod}")
    public CurrencyDto getPriceCurrency(@PathVariable String currencyCod){
        return moexService.getCurrencyMinAndMaxPriceInfo(currencyCod);
    }
}
