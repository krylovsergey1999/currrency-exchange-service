package ru.microservice.currrencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.microservice.currrencyexchangeservice.domain.ExchangeValue;
import ru.microservice.currrencyexchangeservice.service.ExchangeValueService;

import java.math.BigDecimal;

@Controller
public class MainController {
    @Autowired
    private ExchangeValueService exchangeValueService;

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("port", Integer.parseInt(environment.getProperty("local.server.port")));
        return "main";
    }
}
