package com.ada.order.service;

import com.ada.order.model.TypeCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeService {
    private final HttpCustom httpCustom;

    @Autowired
    public ExchangeService(HttpCustom httpCustom) {
        this.httpCustom = httpCustom;
    }

    public BigDecimal getRateExchange(TypeCurrency currency) {
        Double rateExchange = httpCustom.getExchange(currency).getBid();
      return conversionRateExchangeForBigDecimal(rateExchange);
    }

    private static BigDecimal conversionRateExchangeForBigDecimal(Double rateExchange){
        return BigDecimal.valueOf(rateExchange);
    }
}
