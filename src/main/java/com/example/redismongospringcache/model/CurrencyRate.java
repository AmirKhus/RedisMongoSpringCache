package com.example.redismongospringcache.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class CurrencyRate implements Serializable {
    @Id
    private String id;
    private Integer numCode;
    private String charCode;
    private Integer nominal;
    private String name;
    private Double value;
    private Double valueRate;
}
