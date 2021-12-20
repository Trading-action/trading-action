package com.trading.action.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/clientServiceFallBack")
    public String clientServiceFallBackMethod() {
        return "client Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/entrepriseServiceFallBack")
    public String entrepriseServiceFallBackMethod() {
        return "entreprise Service is taking longer than Expected." +
                " Please try again later";
    }
}
