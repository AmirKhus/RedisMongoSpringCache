package com.example.redismongospringcache.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document()
//@RedisHash("CurrencyRate")
public class CurrencyRate implements Serializable {
    @Id
    private String id;
    private String numCode;
    private String charCode;
    private String nominal;
    private String name;
    private String value;
}
