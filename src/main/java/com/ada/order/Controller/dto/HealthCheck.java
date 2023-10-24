package com.ada.order.Controller.dto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @RequestMapping("/")
    public String healthCheck() {

        return "Application Running";
    }
}
