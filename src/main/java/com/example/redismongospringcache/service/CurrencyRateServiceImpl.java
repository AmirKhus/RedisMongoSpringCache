package com.example.redismongospringcache.service;

import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.repository.CurrencyRateDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private final CurrencyRateDBRepository currencyRepository;
    private final CacheService service;

    @Override
    public CurrencyRate save(CurrencyRate currencyRate) {
        return cachedByValue(currencyRate);
    }

    @Override
    public List<CurrencyRate> getAll() {
        return currencyRepository.findAll();
    }

    @Override
    public CurrencyRate getByName(String currencyRateByName) {
        return currencyRepository.findByName(currencyRateByName) != null ? currencyRepository.findByName(currencyRateByName) : null;
    }

    @Override
    public void updatingDataInDBToTheParser(List<CurrencyRate> currency) {
        currency.forEach(this::cachedByValue);
    }

    CurrencyRate cachedByValue(CurrencyRate currencyRate) {
        return service.put(currencyRate);
    }
}
