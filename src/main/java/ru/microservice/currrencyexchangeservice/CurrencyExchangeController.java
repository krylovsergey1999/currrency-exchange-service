package ru.microservice.currrencyexchangeservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveEchangeValue(@PathVariable String from, @PathVariable String to) {
        return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65), port);
    }
}
