package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

public enum CurrencySecID {
//    Для примера, нужно будет добавить в зависимости от требуемыз кол-во валют и СВОП или СВОТ

    EUR("EUR_RUB__TOM"),
    USD("USD000UTSTOM"),
    CNY("CNYRUB_TOM");

    private final String secID;

    CurrencySecID(String secID) {
        this.secID = secID;
    }

    public String getSecID() {
        return secID;
    }
}

