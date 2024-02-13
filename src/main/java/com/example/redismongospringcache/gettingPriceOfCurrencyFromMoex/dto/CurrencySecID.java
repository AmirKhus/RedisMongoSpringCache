package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CurrencySecID {
//    Для примера, нужно будет добавить в зависимости от требуемыз кол-во валют и СВОП или СВОТ

    EUR("EUR_RUB__TOM"),
    USD("USD000UTSTOM"),
    CNY("CNYRUB_TOM");

    private final String secID;
}

