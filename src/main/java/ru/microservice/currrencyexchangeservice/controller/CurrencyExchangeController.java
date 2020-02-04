package ru.microservice.currrencyexchangeservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;
import ru.microservice.currrencyexchangeservice.service.ExchangeValueService;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    ExchangeValueService service;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveEchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue value = service.findByOneAndTwo(from, to);
        ResponseEntity response;
        if (value != null) {
            value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            response = ResponseEntity.ok(value);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }
}
// new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65), port);