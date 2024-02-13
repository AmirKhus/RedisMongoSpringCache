package com.example.redismongospringcache.caching;

import com.example.redismongospringcache.exception.ExceptionService;
import com.example.redismongospringcache.model.CurrencyRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {
    private final CacheManager manager;
    private final ExceptionService exceptionService;

    @Override
    public CurrencyRate put(CurrencyRate currencyRate) {
        log.info("put in cache - " + currencyRate.toString());
        var cache = manager.getCache("CurrencyRate");
        assert cache != null : exceptionService.nullPointerException("Cache is null from put()");
        cache.put(currencyRate.getId(), currencyRate);
        return currencyRate;
    }

    @Override
    public void delete(String id) {
        log.info("delete in cache - " + id);
        var cache = manager.getCache("CurrencyRate");
        assert cache != null : exceptionService.nullPointerException("Cache is null from delete()");
        cache.evict(id);
    }

}
