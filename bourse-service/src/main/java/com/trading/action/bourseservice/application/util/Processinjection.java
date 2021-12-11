package com.trading.action.bourseservice.application.util;

import com.trading.action.bourseservice.domain.entreprise.create.EntrepriseCreateProcess;
import com.trading.action.bourseservice.domain.entreprise.create.EntrepriseCreateProcessImpl;
import com.trading.action.bourseservice.domain.price.change.PriceChangeProcess;
import com.trading.action.bourseservice.domain.price.change.PriceChangeProcessImpl;
import com.trading.action.bourseservice.infra.facade.EntrepriseInfra;
import com.trading.action.bourseservice.infra.facade.PriceInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {
    @Bean
    public EntrepriseCreateProcess entrepriseCreateProcess(EntrepriseInfra entrepriseInfra){
        return new EntrepriseCreateProcessImpl(entrepriseInfra);
    }
    @Bean
    public PriceChangeProcess priceChangeProcess(EntrepriseInfra entrepriseInfra, PriceInfra priceInfra){
        return new PriceChangeProcessImpl(entrepriseInfra, priceInfra);
    }
}

