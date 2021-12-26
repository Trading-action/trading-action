package com.example.commissionservice.domain.commissionDetail.create;

import com.example.commissionservice.domain.core.AbstractProcessInput;
import com.example.commissionservice.domain.pojo.CommissionDetail;

public class CommissionDetailCreateInput extends AbstractProcessInput {
    CommissionDetail commissionDetail;

    public CommissionDetail getCommissionDetail() {
        return commissionDetail;
    }

    public void setCommissionDetail(CommissionDetail commissionDetail) {
        this.commissionDetail = commissionDetail;
    }
}
