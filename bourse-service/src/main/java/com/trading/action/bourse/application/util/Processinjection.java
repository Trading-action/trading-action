package com.trading.action.bourse.application.util;

import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateProcess;
import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateProcessImpl;
import com.trading.action.bourse.infra.facade.EntrepriseInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {
    @Bean
    public EntrepriseCreateProcess actionnaireCreateProcess(EntrepriseInfra entrepriseInfra){
        return new EntrepriseCreateProcessImpl(entrepriseInfra) {
        };
    }
}

