package com.example.commissionservice.domain.commission.create;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.Action;
import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.infra.facade.CommissionInfra;

public class CommissionCreateProcessImpl extends AbstractProcessImpl<CommissionCreateInput> implements CommissionCreateProcess {

    private final CommissionInfra commissionInfra;

    public CommissionCreateProcessImpl(CommissionInfra commissionInfra) {
        this.commissionInfra = commissionInfra;
    }

    @Override
    public void validate(CommissionCreateInput commissionCreateInput, Result result) {
        Commission commission = commissionInfra.findByRef(commissionCreateInput.getRef());
        if (commission != null) {
            result.addErrorMessage(commissionInfra.getMessage("commission.already_exists"));
        }
    }

    @Override
    public void run(CommissionCreateInput commissionCreateInput, Result result) {
        Commission commission = new Commission();
        commission.setRef(commissionCreateInput.getRef());
        commission.setTotalPrice(commissionCreateInput.getTotalPrice());
        commission.setDateCommission(commissionCreateInput.getDateCommission());
        Action action = new Action(commissionCreateInput.getRefAction());
        commission.setAction(action);
        commissionInfra.save(commission);
        result.addInfoMessage(commissionInfra.getMessage("commission.created"));
    }
}
