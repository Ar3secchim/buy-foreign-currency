package com.ada.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/*@Entity(name = "exchange")*/

public class Exchange{
    private String Currency;
    private double rate;
}
