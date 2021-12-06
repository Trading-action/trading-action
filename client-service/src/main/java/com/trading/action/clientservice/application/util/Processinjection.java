package com.trading.action.clientservice.application.util;


import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreateProcess;
import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreateProcessImpl;
import com.trading.action.clientservice.domain.compte.create.CompteCreateProcess;
import com.trading.action.clientservice.domain.compte.create.CompteCreateProcessImpl;
import com.trading.action.clientservice.domain.pojo.Portefeuille;
import com.trading.action.clientservice.domain.portefeuille.PortefeuilleProcess;
import com.trading.action.clientservice.domain.portefeuille.PortefeuilleProcessImpl;
import com.trading.action.clientservice.infra.facade.ActionInfra;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;
import com.trading.action.clientservice.infra.facade.CompteInfra;
import com.trading.action.clientservice.infra.facade.CompteTypeInfra;
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
    public PortefeuilleProcess portefeuilleProcess(ActionInfra actionInfra, ActionnaireInfra actionnaireInfra){
        return new PortefeuilleProcessImpl(actionInfra,actionnaireInfra);
    }

}

