package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.controller;

import com.example.redismongospringcache.exception.ExceptionService;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto.CurrencyPriceMaxAndMinDto;
import com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.service.MoexService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MoexController {

    private final MoexService moexService;
    private final ExceptionService exceptionService;

    @GetMapping("/moex/{currencyCod}")
    public CurrencyPriceMaxAndMinDto getPriceCurrency(@PathVariable String currencyCod) {
        assert currencyCod != null : exceptionService.illegalArgumentException("currencyCod is null from getPriceCurrency()");
        return moexService.getCurrencyMinAndMaxPriceInfo(currencyCod);
    }
}
