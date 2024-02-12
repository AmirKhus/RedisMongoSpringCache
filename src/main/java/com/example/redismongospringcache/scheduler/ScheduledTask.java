package com.example.redismongospringcache.scheduler;

import com.example.redismongospringcache.parser.service.CurrencyRateParserService;
import com.example.redismongospringcache.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduledTask implements ScheduledService {

    private final CurrencyRateService currencyRateService;
    private final CurrencyRateParserService currencyRateParser;

    @Override
    @Scheduled(cron = "0 1 15 * * 1,2,3,4,5", zone = "Europe/Moscow")
    public void schedule() {
        log.info("Start schedule for check update currency rate");
        var currencies = currencyRateParser.getAllCurrenciesRateByDefaultURL();
        currencyRateService.updatingDataInDBToTheParser(currencies);
        log.info("Stop schedule  for check update currency rate");
    }
}
