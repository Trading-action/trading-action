package com.example.commissionservice.application.utils;


import com.example.commissionservice.domain.TypeCommission.create.TypeCommissionCreateProcess;
import com.example.commissionservice.domain.TypeCommission.create.TypeCommissionCreateProcessImpl;
import com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions.FindApplicableTypeCommissionsProcess;
import com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions.FindApplicableTypeCommissionsProcessImpl;
import com.example.commissionservice.domain.commission.calculate.CommissionCalculateProcess;
import com.example.commissionservice.domain.commission.calculate.CommissionCalculateProcessImpl;
import com.example.commissionservice.domain.commission.create.CommissionCreateProcess;
import com.example.commissionservice.domain.commission.create.CommissionCreateProcessImpl;
import com.example.commissionservice.domain.commissionDetail.create.CommissionDetailCreateProcess;
import com.example.commissionservice.domain.commissionDetail.create.CommissionDetailCreateProcessImpl;
import com.example.commissionservice.domain.commissionDetail.findByCommissionRef.FindByCommissionRefProcess;
import com.example.commissionservice.domain.commissionDetail.findByCommissionRef.FindByCommissionRefProcessImpl;
import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.infra.facade.CommissionDetailInfra;
import com.example.commissionservice.infra.facade.CommissionInfra;
import com.example.commissionservice.infra.facade.TypeCommissionInfra;
import com.example.commissionservice.infra.required.BourseService;
import com.example.commissionservice.infra.required.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessInjection {

    @Bean
    public CommissionCreateProcess commissionCreateProcess(CommissionInfra commissionInfra) {
        return new CommissionCreateProcessImpl(commissionInfra);
    }

    @Bean
    public TypeCommissionCreateProcess typeCommissionCreateProcess(TypeCommissionInfra typeCommissionInfra) {
        return new TypeCommissionCreateProcessImpl(typeCommissionInfra);
    }

    @Bean
    public FindApplicableTypeCommissionsProcess findApplicableTypeCommissionsProcess(TypeCommissionInfra typeCommissionInfra, ClientService clientService) {
        return new FindApplicableTypeCommissionsProcessImpl(typeCommissionInfra, clientService);
    }

    @Bean
    public CommissionCalculateProcess commissionCalculateProcess(CommissionInfra commissionInfra, ClientService clientService, BourseService bourseService) {
        return new CommissionCalculateProcessImpl(commissionInfra, clientService, bourseService);
    }

    @Bean
    public CommissionDetailCreateProcess commissionDetailCreateProcess(CommissionDetailInfra commissionDetailInfra, TypeCommissionInfra typeCommissionInfra) {
        return new CommissionDetailCreateProcessImpl(commissionDetailInfra, typeCommissionInfra);
    }

    @Bean
    public FindByCommissionRefProcess findByCommissionRefProcess(CommissionInfra commissionInfra) {
        return new FindByCommissionRefProcessImpl(commissionInfra);
    }
}

