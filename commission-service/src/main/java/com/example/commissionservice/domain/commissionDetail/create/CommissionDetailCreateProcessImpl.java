package com.example.commissionservice.domain.commissionDetail.create;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.facade.CommissionDetailInfra;
import com.example.commissionservice.infra.facade.TypeCommissionInfra;

public class CommissionDetailCreateProcessImpl extends AbstractProcessImpl<CommissionDetailCreateInput> implements CommissionDetailCreateProcess {

    private CommissionDetailInfra commissionDetailInfra;
    private TypeCommissionInfra typeCommissionInfra;

    public CommissionDetailCreateProcessImpl(CommissionDetailInfra commissionDetailInfra, TypeCommissionInfra typeCommissionInfra) {
        this.commissionDetailInfra = commissionDetailInfra;
        this.typeCommissionInfra = typeCommissionInfra;
    }

    @Override
    public void validate(CommissionDetailCreateInput commissionDetailCreateInput, Result result) {
        CommissionDetail commissionDetail = commissionDetailInfra.findByRef(commissionDetailCreateInput.getCommissionDetail().getRef());
        if (commissionDetail != null){
            result.addErrorMessage(commissionDetailInfra.getMessage("CommissionDetail.already_exists"));
        }
        TypeCommission typeCommission = typeCommissionInfra.findByRef(commissionDetailCreateInput.getCommissionDetail().getTypeCommission().getRef());
        if (typeCommission == null){
            result.addErrorMessage(typeCommissionInfra.getMessage("CommissionDetail.typeCommission.not_exists"));
        }
    }

    @Override
    public void run(CommissionDetailCreateInput commissionDetailCreateInput, Result result) {
        CommissionDetail commissionDetail = commissionDetailCreateInput.getCommissionDetail();
        commissionDetailInfra.save(commissionDetail);
        result.addInfoMessage(commissionDetailInfra.getMessage("CommissionDetail.created"));
    }
}
