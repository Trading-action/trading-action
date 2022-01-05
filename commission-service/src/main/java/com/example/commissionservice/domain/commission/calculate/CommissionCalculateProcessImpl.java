package com.example.commissionservice.domain.commission.calculate;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.infra.facade.CommissionInfra;
import com.example.commissionservice.infra.required.BourseService;
import com.example.commissionservice.infra.required.ClientService;


public class CommissionCalculateProcessImpl extends AbstractProcessImpl<CommissionCalculateInput> implements CommissionCalculateProcess {

    private final CommissionInfra commissionInfra;
    private final ClientService clientService;
    private final BourseService bourseService;

    public CommissionCalculateProcessImpl(CommissionInfra commissionInfra, ClientService clientService, BourseService bourseService) {
        this.commissionInfra = commissionInfra;
        this.clientService = clientService;
        this.bourseService = bourseService;
    }

    @Override
    public void validate(CommissionCalculateInput commissionCalculateInput, Result result) {

        // Check if the Action is not null!
        if (commissionCalculateInput.getAction() == null) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.NullAction"));
        }

        // Check if the Account is not null!
        if (commissionCalculateInput.getCompte() == null) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.NullAccount"));
        }

        // Check if the Operation Type is not null!
        if (commissionCalculateInput.getOperationType() == null || commissionCalculateInput.getOperationType() == "") {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.NullOperationType"));
        }

        // Check if the Operation Type is either ACHAT or VENTE
        if (!commissionCalculateInput.getOperationType().equalsIgnoreCase("ACHAT") && !commissionCalculateInput.getOperationType().equalsIgnoreCase("VENTE")) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.InvalidOperationType"));
        }

        // Check if the Account Type reference is not null!
        if (commissionCalculateInput.getCompte().getRefTypeCompte() == null) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.NullCompteType"));
        }

        Result compteResult = clientService.findCompteByRef(commissionCalculateInput.getCompte().getRef());

        // Check if the Account exists!
        if (compteResult.getOutput() == null){
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.CompteNotFound"));
        }

        Result compteTypeResult = clientService.findCompteTypeByRef(commissionCalculateInput.getCompte().getRefTypeCompte());

        // Check if the Account Type exists!
        if (compteTypeResult.getOutput() == null) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.CompteTypeNotFound"));
        }

        Result actionResult = bourseService.findActionByRef(commissionCalculateInput.getAction().getRef());

        // Check if the Action Type exists!
        if (actionResult.getOutput() == null) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.ActionNotFound"));
        }
    }

    @Override
    public void run(CommissionCalculateInput commissionCalculateInput, Result result) {
        result.setOutput(commissionInfra.calculateCommission(commissionCalculateInput.getAction(), commissionCalculateInput.getCompte(), commissionCalculateInput.getOperationType()));
    }
}
