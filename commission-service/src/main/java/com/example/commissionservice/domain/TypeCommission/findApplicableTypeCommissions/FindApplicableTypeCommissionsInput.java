package com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions;

import com.example.commissionservice.domain.core.AbstractProcessInput;

import java.time.Instant;

public class FindApplicableTypeCommissionsInput extends AbstractProcessInput {
    Instant operationDate;
    String operationType;
    String refTypeCompte;

    public Instant getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Instant operationDate) {
        this.operationDate = operationDate;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getRefTypeCompte() {
        return refTypeCompte;
    }

    public void setRefTypeCompte(String refTypeCompte) {
        this.refTypeCompte = refTypeCompte;
    }
}


