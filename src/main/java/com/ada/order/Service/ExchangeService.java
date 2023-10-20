package com.ada.order.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    private final HttpCustom httpCustom;
    @Autowired
    public ExchangeService(HttpCustom httpCustom) {
        this.httpCustom = httpCustom;
    }

    public HttpCustom getHttpCustom(String currency) {
        return httpCustom;
    }
}
