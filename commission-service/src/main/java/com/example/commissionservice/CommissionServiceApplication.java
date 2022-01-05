package com.example.commissionservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
@EnableDiscoveryClient
@OpenAPIDefinition(info =
@Info(title = "Commission API", version = "1.0", description = "Documentation Commission API v1.0")
)
public class CommissionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommissionServiceApplication.class, args);
    }

}
