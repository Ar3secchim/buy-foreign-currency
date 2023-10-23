package com.ada.order.service;

import com.ada.order.model.Exchange;
import com.ada.order.model.TypeCurrency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import org.springframework.web.client.RestTemplate;

@Service
public class HttpCustom {
    private final RestTemplate restTemplate;

    public HttpCustom() {
        this.restTemplate = new RestTemplate();
    }

    public Exchange getExchange(TypeCurrency currency) {
        String baseUrl = "https://economia.awesomeapi.com.br/json/" + currency;

        try {
            Exchange[] response = restTemplate.getForObject(baseUrl, Exchange[].class);

            if (response != null && response.length > 0) {
                return response[0];
            }
        } catch (RestClientException error) {
            //TODO lançar erro e tratar erro
            error.getMessage();
            return null;
        }
        return null;
    }
}
