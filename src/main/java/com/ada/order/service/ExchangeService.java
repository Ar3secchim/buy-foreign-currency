package com.ada.order.service;

import com.ada.order.model.Exchange;
import com.ada.order.model.TypeCurrency;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Getter
@Setter
@Service
public class ExchangeService {
    private final HttpCustom httpCustom;

    @Autowired
    public ExchangeService(HttpCustom httpCustom) {
        this.httpCustom = httpCustom;
    }

    public BigDecimal getRateExchange(TypeCurrency currency) {
       Exchange exchangeResponse = httpCustom.getExchange(currency);

        if (exchangeResponse != null) {
            Double rateExchange = exchangeResponse.getBid();
            return conversionRateExchangeForBigDecimal(rateExchange);
        }
        return null;
    }

    private static BigDecimal conversionRateExchangeForBigDecimal(Double rateExchange){
        return BigDecimal.valueOf(rateExchange);
    }

    public static BigDecimal fetchExchangeRateAPI(TypeCurrency typeCurrency){
        BigDecimal exchangeRate = BigDecimal.valueOf(1.2);
        return exchangeRate;
    }
}
