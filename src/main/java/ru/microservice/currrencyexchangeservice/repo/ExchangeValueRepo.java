package ru.microservice.currrencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;

@Repository
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByOneAndTwo(String one, String two);
}
