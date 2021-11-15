package com.trading.action.clientservice.application.util;


import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreateProcess;
import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreateProcessImpl;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {

    @Bean
    public ActionnaireCreateProcess actionnaireCreateProcess(ActionnaireInfra actionnaireInfra){
        return new ActionnaireCreateProcessImpl(actionnaireInfra);
    }

}

