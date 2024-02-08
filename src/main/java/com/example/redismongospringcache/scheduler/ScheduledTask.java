package com.example.redismongospringcache.scheduler;

import com.example.redismongospringcache.controller.CurrencyRateController;
import com.example.redismongospringcache.model.CurrencyEnum;
import com.example.redismongospringcache.service.CurrencyRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ScheduledTask implements ScheduledService {

    @Autowired
    CurrencyRateService currencyRateService;

    @Override
    @Scheduled(cron = "* 11 16 * * 1,2,3,4,5", zone = "Europe/Moscow")
    public void schedule() {

        log.info("Start schedule for check update currency rate");
        List<String> currency = Arrays.stream(CurrencyEnum.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        for (String currencyName : currency) {
            System.out.println(currencyRateService.updatingDataInDBToTheParser(currencyName));
        }
        log.info("Stop schedule  for check update currency rate");
    }
}
