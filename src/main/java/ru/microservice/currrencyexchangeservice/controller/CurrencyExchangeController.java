package ru.microservice.currrencyexchangeservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;
import ru.microservice.currrencyexchangeservice.service.ExchangeValueService;

@Slf4j
@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    ExchangeValueService service;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveEchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue value = service.findByFromAndTo(from, to);
        value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        log.info(value.toString());
        return value;
    }
}
// new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65), port);