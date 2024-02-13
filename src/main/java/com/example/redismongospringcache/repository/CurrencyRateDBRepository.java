package com.example.redismongospringcache.repository;

import com.example.redismongospringcache.model.CurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateDBRepository extends MongoRepository<CurrencyRate, String> {
    CurrencyRate findByName(String name);

    void deleteById(String id);
}
