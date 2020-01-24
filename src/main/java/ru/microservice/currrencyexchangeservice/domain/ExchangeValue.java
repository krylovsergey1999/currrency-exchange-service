package ru.microservice.currrencyexchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ExchangeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String from_my;

    private String to_my;

    private BigDecimal conversionMultiple;
    private int port;
}
