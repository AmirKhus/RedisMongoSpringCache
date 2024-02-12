package com.example.redismongospringcache;

import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.repository.CurrencyRateDBRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Objects;

@SpringBootApplication
public class RedisMongoSpringCacheApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(RedisMongoSpringCacheApplication.class, args);
		context.getBean(CurrencyRateDBRepository.class).deleteAll();
		var ch = context.getBean(RedisCacheManager.class);
		ch.getCacheNames().forEach(obj-> Objects.requireNonNull(ch.getCache(obj)).clear());
//		var survey = context.getBean(CurrencyRate.class);
//		survey.interview();
	}

}
