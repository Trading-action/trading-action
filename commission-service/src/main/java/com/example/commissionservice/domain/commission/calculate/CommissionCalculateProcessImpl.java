package com.example.commissionservice.domain.commission.calculate;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.infra.facade.CommissionInfra;


public class CommissionCalculateProcessImpl extends AbstractProcessImpl<CommissionCalculateInput> implements CommissionCalculateProcess {

    private CommissionInfra commissionInfra;

    public CommissionCalculateProcessImpl(CommissionInfra commissionInfra) {
        this.commissionInfra = commissionInfra;
    }

    @Override
    public void validate(CommissionCalculateInput commissionCalculateInput, Result result) {
        if (commissionCalculateInput.getAction() == null) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.NullAction"));
        }

        if (commissionCalculateInput.getCompte() == null) {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.NullAccount"));
        }

        if (commissionCalculateInput.getOperationType() == null || commissionCalculateInput.getOperationType() == "") {
            result.addErrorMessage(commissionInfra.getMessage("Commission.CommissionCalculate.NullOperationType"));
        }
    }

    @Override
    public void run(CommissionCalculateInput commissionCalculateInput, Result result) {
        result.setOutput(commissionInfra.calculateCommission(commissionCalculateInput.getAction(), commissionCalculateInput.getCompte(), commissionCalculateInput.getOperationType()));
    }
}
