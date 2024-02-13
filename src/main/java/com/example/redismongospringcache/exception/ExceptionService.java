package com.example.redismongospringcache.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExceptionService {
    public NullPointerException nullPointerException(String message) {
        log.error(message);
        throw new NullPointerException(message);
    }

    public IllegalArgumentException illegalArgumentException(String message) {
        log.error(message);
        throw new IllegalArgumentException(message);
    }

}
