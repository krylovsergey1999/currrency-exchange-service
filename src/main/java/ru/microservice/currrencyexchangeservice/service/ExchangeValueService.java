package ru.microservice.currrencyexchangeservice.service;

import org.springframework.stereotype.Service;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;
import ru.microservice.currrencyexchangeservice.repo.ExchangeValueRepo;

@Service
public class ExchangeValueService {
    private final ExchangeValueRepo exchangeValueRepo;

    public ExchangeValueService(ExchangeValueRepo exchangeValueRepo) {
        this.exchangeValueRepo = exchangeValueRepo;
    }


    public ExchangeValue findByFromAndTo(String from, String to) {
        return exchangeValueRepo.findByFromAndTo(from, to);
    }
}
