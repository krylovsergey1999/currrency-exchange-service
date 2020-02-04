package ru.microservice.currrencyexchangeservice.controller;


import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveEchangeValue(@PathVariable String from, @PathVariable String to) {
        return ExchangeValue.builder()
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .id(1L)
                .from_my(from)
                .to_my(to)
                .conversionMultiple(BigDecimal.valueOf(65))
                .build();
    }
}
// new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65), port);