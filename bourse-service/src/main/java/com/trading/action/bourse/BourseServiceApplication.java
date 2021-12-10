package com.trading.action.bourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BourseServiceApplication.class, args);
    }

}
