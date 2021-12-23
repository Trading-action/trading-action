package com.trading.action.bourseservice.application.util;

import com.trading.action.bourseservice.domain.create.ActionCreateProcess;
import com.trading.action.bourseservice.domain.create.ActionCreateProcessImpl;
import com.trading.action.bourseservice.infra.facade.ActionInfra;
import com.trading.action.bourseservice.infra.required.ActionnaireService;
import com.trading.action.bourseservice.infra.required.EntrepriseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {
    @Bean
    public ActionCreateProcess actionCreateProcess(EntrepriseService entrepriseService, ActionnaireService actionnaireService, ActionInfra actionInfra){
        return new ActionCreateProcessImpl(entrepriseService,actionnaireService,actionInfra);
    }
}

