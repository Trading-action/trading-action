package com.example.commissionservice.domain.commissionDetail.findByCommissionRef;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.infra.facade.CommissionInfra;

public class FindByCommissionRefProcessImpl extends AbstractProcessImpl<FindByCommissionRefInput> implements FindByCommissionRefProcess {

    private CommissionInfra commissionInfra;

    public FindByCommissionRefProcessImpl(CommissionInfra commissionInfra) {
        this.commissionInfra = commissionInfra;
    }

    @Override
    public void validate(FindByCommissionRefInput findByCommissionRefInput, Result result) {
        if (findByCommissionRefInput.getRefCommission() == null || findByCommissionRefInput.getRefCommission() == "") {
            result.addErrorMessage(commissionInfra.getMessage("CommissionDetail.findByCommissionRef.RefCommissionNull"));
        }
        Commission commission = commissionInfra.findByRef(findByCommissionRefInput.getRefCommission());

        if (commission == null){
            result.addErrorMessage(commissionInfra.getMessage("CommissionDetail.findByCommissionRef.not_exist"));
        }
    }

    @Override
    public void run(FindByCommissionRefInput findByCommissionRefInput, Result result) {
        Commission commission = commissionInfra.findByRef(findByCommissionRefInput.getRefCommission());
        result.addInfoMessage(commissionInfra.getMessage("CommissionDetail.findByCommissionRef.found"));
        result.setOutput(commission.getCommissionDetails());
    }
}
