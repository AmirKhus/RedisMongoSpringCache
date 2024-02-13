package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum for storing sec id for each currency
 */
@Getter
@AllArgsConstructor
public enum CurrencySecID {
//    Данные для примера, нужно будет добавить в зависимости от требуемого ТЗ кол-во валют и СВОП или СВОТ

    EUR("EUR_RUB__TOM"),
    USD("USD000UTSTOM"),
    CNY("CNYRUB_TOM");
    private String secID;
}

