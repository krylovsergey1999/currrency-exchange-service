package ru.microservice.currrencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;
import ru.microservice.currrencyexchangeservice.service.ExchangeValueService;

import java.math.BigDecimal;

@RestController
public class MainController {
    @Autowired
    private ExchangeValueService exchangeValueService;

    @GetMapping("/")
    public void main() {
        ExchangeValue exchangeValue = ExchangeValue.builder()
                .from_my("US")
                .port(8000)
                .to_my("RU")
                .conversionMultiple(BigDecimal.valueOf(60))
                .build();
        exchangeValueService.add(exchangeValue);
        System.out.println("Добавление");
    }
}
