package com.ada.order.service;

import com.ada.order.model.Exchange;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@Configuration
public class HttpCustom {
  private String URL;

  WebClient webClient(){
    return WebClient.builder().baseUrl(URL)
      .build();
  }

  public  Exchange getExchange(String currency) {
    URL = "https://economia.awesomeapi.com.br/json/" + currency;

    try {
      WebClient webClient = webClient();

      ResponseEntity<List<Exchange>> price = webClient.get()
        .retrieve()
        .onStatus(
          status -> !status.is2xxSuccessful(),
          response -> {
              throw new ResponseStatusException(response.statusCode(), "Error retrieving currency");
          }
        ).toEntity(new ParameterizedTypeReference<List<Exchange>>() {
        }).block();

        if (price != null) {
            return Objects.requireNonNull(price.getBody()).get(0);
        }
      } catch (ResponseStatusException ex) {
          throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
      }
      return null;
    }
}
