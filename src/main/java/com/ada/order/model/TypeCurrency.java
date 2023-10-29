package com.ada.order.model;

import java.util.EnumSet;
import java.util.Set;

public enum TypeCurrency {
  USD,
  EUR;

  public static final Set<TypeCurrency> VALID_CURRENCIES = EnumSet.allOf(TypeCurrency.class);

  public boolean isValidCurrency(TypeCurrency currency) {
    return TypeCurrency.VALID_CURRENCIES.contains(currency);
  }
};
