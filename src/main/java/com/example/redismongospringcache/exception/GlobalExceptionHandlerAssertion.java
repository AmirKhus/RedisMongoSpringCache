package com.example.redismongospringcache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerAssertion {
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionEntity illegal(Exception exception) {
        return new ExceptionEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ExceptionEntity nullPointer(Exception exception) {
        return new ExceptionEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
