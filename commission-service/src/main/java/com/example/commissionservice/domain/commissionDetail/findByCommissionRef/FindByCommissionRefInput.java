package com.example.commissionservice.domain.commissionDetail.findByCommissionRef;

import com.example.commissionservice.domain.core.AbstractProcessInput;

public class FindByCommissionRefInput extends AbstractProcessInput {
    private String refCommission;

    public String getRefCommission() {
        return refCommission;
    }

    public void setRefCommission(String refCommission) {
        this.refCommission = refCommission;
    }
}
