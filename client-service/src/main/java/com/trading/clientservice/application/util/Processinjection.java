package com.trading.clientservice.application.util;


import com.trading.clientservice.domain.actionnaire.create.ActionnaireCreateProcess;
import com.trading.clientservice.domain.actionnaire.create.ActionnaireCreateProcessImpl;
import com.trading.clientservice.domain.compte.create.CompteCreateProcess;
import com.trading.clientservice.domain.compte.create.CompteCreateProcessImpl;
import com.trading.clientservice.domain.portefeuille.PortefeuilleProcess;
import com.trading.clientservice.domain.portefeuille.PortefeuilleProcessImpl;
import com.trading.clientservice.infra.facade.ActionnaireInfra;
import com.trading.clientservice.infra.facade.CompteInfra;
import com.trading.clientservice.infra.facade.CompteTypeInfra;
import com.trading.clientservice.infra.required.BourseService;
import com.trading.clientservice.infra.required.EntrepriseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {

    @Bean
    public ActionnaireCreateProcess actionnaireCreateProcess(ActionnaireInfra actionnaireInfra, CompteInfra compteInfra){
        return new ActionnaireCreateProcessImpl(actionnaireInfra,compteInfra);
    }

    @Bean
    public CompteCreateProcess compteCreateProcess(CompteInfra compteInfra, CompteTypeInfra compteTypeInfra){
        return new CompteCreateProcessImpl(compteInfra,compteTypeInfra);
    }


    @Bean
    public PortefeuilleProcess portefeuilleProcess(BourseService bourseService,EntrepriseService entrepriseService, ActionnaireInfra actionnaireInfra){
        return new PortefeuilleProcessImpl(bourseService,entrepriseService,actionnaireInfra);
    }

}

