package com.ada.order.controller.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class LoginRequest {
  @Email
  private String cpf;
  private String password;
}
