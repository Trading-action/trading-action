package com.example.commissionservice.domain.commission.calculate;

import java.time.Instant;

public class CommissionCalculateInput {
    private String refAction;
    // This is can be the date of the commission!
    private Instant dateOperation;

    public String getRefAction() {
        return refAction;
    }

    public void setRefAction(String refAction) {
        this.refAction = refAction;
    }

    public Instant getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Instant dateOperation) {
        this.dateOperation = dateOperation;
    }
}
