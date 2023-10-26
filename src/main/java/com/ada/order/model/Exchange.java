package com.ada.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exchange{
    private String codein;
    private Double bid;
    private Double ask;
}
