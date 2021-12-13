package com.trading.action.entreprise.application.util;

import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateProcess;
import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateProcessImpl;
import com.trading.action.entreprise.domain.price.change.PriceChangeProcess;
import com.trading.action.entreprise.domain.price.change.PriceChangeProcessImpl;
import com.trading.action.entreprise.domain.price.history.PriceHistoryByDateAndEntrepriseProcess;
import com.trading.action.entreprise.domain.price.history.PriceHistoryByDateAndEntrepriseProcessImpl;
import com.trading.action.entreprise.infra.facade.EntrepriseInfra;
import com.trading.action.entreprise.infra.facade.PriceInfra;
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
    @Bean
    public PriceHistoryByDateAndEntrepriseProcess priceHistoryByDateAndEntrepriseProcess(EntrepriseInfra entrepriseInfra, PriceInfra priceInfra){
        return new PriceHistoryByDateAndEntrepriseProcessImpl(entrepriseInfra, priceInfra);
    }
}

