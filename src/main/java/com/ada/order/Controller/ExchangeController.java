package com.ada.order.Controller;

import com.ada.order.Service.HttpCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    @Autowired
    private HttpCustom exchangeService;

    @GetMapping("/usd")
    public double getUSDCurrency() {
        return exchangeService.getUSDCurrency();
    }

    @GetMapping("/eur")
    public double getEURCurrency() {
        return exchangeService.getEURCurrency();
    }
}