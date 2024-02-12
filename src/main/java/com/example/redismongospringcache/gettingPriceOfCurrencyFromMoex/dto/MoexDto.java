package com.example.redismongospringcache.gettingPriceOfCurrencyFromMoex.dto;

import lombok.Data;
import lombok.Setter;
import org.bson.json.JsonObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import java.util.List;

@Data
public class MoexDto {
    private MarketData marketdata;
}
