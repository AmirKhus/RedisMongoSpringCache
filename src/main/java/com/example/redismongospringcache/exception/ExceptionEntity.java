package com.example.redismongospringcache.exception;

import org.springframework.http.HttpStatusCode;


public record ExceptionEntity(String message, HttpStatusCode code) {
}
