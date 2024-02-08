package com.example.redismongospringcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisMongoSpringCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisMongoSpringCacheApplication.class, args);
	}

}
