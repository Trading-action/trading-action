package com.trading.action.bourse.application.util;

import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateProcess;
import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateProcessImpl;
import com.trading.action.bourse.domain.price.change.PriceChangeProcess;
import com.trading.action.bourse.domain.price.change.PriceChangeProcessImpl;
import com.trading.action.bourse.infra.facade.EntrepriseInfra;
import com.trading.action.bourse.infra.facade.PriceInfra;
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

