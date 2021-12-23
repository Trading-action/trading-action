package com.example.commissionservice.application.utils;


import com.example.commissionservice.domain.commission.create.CommissionCreateProcess;
import com.example.commissionservice.domain.commission.create.CommissionCreateProcessImpl;
import com.example.commissionservice.infra.facade.CommissionInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessInjection {

    @Bean
    public CommissionCreateProcess commissionCreateProcess(CommissionInfra commissionInfra){
        return new CommissionCreateProcessImpl(commissionInfra);
    }
}

