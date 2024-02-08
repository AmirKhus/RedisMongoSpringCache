package com.example.redismongospringcache.parser.service;

import com.example.redismongospringcache.model.CurrencyRate;
import com.example.redismongospringcache.parser.parser.CurrencyRateParser;
import com.example.redismongospringcache.parser.parser.CurrencyRateParserXml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class CurrencyRateParserServiceIml implements CurrencyRateParserService {
    @Value("${parse.dateFormat}")
    private String DATE_FORMAT;

    @Autowired
    private CurrencyRateParser currencyRateParser = new CurrencyRateParserXml();


    @Value("${parse.url}")
    private String urlParse;

    public CurrencyRate getCurrencyRate(String currency, LocalDate date) {
        log.info("getCurrencyRate. currency:{}", currency);
        System.out.println(DATE_FORMAT);
        List<CurrencyRate> rates;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String urlWithParams = String.format("%s?date_req=%s", urlParse, dateTimeFormatter.format(date));
        String ratesAsXml = getRatesAsXml(urlWithParams);
        rates = currencyRateParser.parse(ratesAsXml);
        return rates.stream().filter(rate -> currency.equals(rate.getCharCode()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Currency Rate not found. Currency:" + currency));
    }

    public String getRatesAsXml(String url) {
        try {
            log.info("request for url:{}", url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception ex) {
            if (ex instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            log.error("cbr request error, url:{}", url, ex);
            throw new RuntimeException(ex);
        }
    }
}