package com.ada.order.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CurrencyResponse {
    @JsonProperty("high")
    private double value;
}
