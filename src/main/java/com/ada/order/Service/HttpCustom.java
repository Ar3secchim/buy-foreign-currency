package com.ada.order.Service;

import com.ada.order.model.Exchange;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpCustom {
    private final String baseUrl = "https://economia.awesomeapi.com.br";
    private final RestTemplate restTemplate;

    public HttpCustom() {
        this.restTemplate = new RestTemplate();
    }

    public double getUSDCurrency() {
        ResponseEntity<Exchange> response = restTemplate.getForEntity(baseUrl + "/USD", Exchange.class);
        return response.getBody().getRate();
    }

    public double getEURCurrency() {
        ResponseEntity<Exchange> response = restTemplate.getForEntity(baseUrl + "/EUR", Exchange.class);
        return response.getBody().getRate();
    }

}
