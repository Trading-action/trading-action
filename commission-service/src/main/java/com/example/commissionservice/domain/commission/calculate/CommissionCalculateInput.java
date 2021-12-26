package com.example.commissionservice.domain.commission.calculate;

import com.example.commissionservice.domain.core.AbstractProcessInput;
import com.example.commissionservice.domain.pojo.Action;
import com.example.commissionservice.domain.pojo.Compte;

import java.time.Instant;

public class CommissionCalculateInput extends AbstractProcessInput {
    private Action action;
    private Compte compte;
    private String operationType;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
