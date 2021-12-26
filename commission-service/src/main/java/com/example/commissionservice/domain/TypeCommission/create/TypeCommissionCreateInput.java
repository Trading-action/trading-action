package com.example.commissionservice.domain.TypeCommission.create;

import com.example.commissionservice.domain.core.AbstractProcessInput;
import com.example.commissionservice.domain.pojo.CompteType;
import com.example.commissionservice.domain.pojo.TransactionType;

import java.time.Instant;

public class TypeCommissionCreateInput extends AbstractProcessInput {
    String ref;
    String label;
    Instant applicationDateMin;
    Instant applicationDateMax;
    CompteType compteType;
    Float percentage;
    boolean tva;
    double minimal;
    String operationType;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Instant getApplicationDateMin() {
        return applicationDateMin;
    }

    public void setApplicationDateMin(Instant applicationDateMin) {
        this.applicationDateMin = applicationDateMin;
    }

    public Instant getApplicationDateMax() {
        return applicationDateMax;
    }

    public void setApplicationDateMax(Instant applicationDateMax) {
        this.applicationDateMax = applicationDateMax;
    }

    public CompteType getCompteType() {
        return compteType;
    }

    public void setCompteType(CompteType compteType) {
        this.compteType = compteType;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public boolean isTva() {
        return tva;
    }

    public void setTva(boolean tva) {
        this.tva = tva;
    }

    public double getMinimal() {
        return minimal;
    }

    public void setMinimal(double minimal) {
        this.minimal = minimal;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "TypeCommissionCreateInput{" +
                "ref='" + ref + '\'' +
                ", label='" + label + '\'' +
                ", applicationDateMin=" + applicationDateMin +
                ", applicationDateMax=" + applicationDateMax +
                ", compteType=" + compteType +
                ", percentage=" + percentage +
                ", tva=" + tva +
                ", minimal=" + minimal +
                ", operationType=" + operationType +
                '}';
    }
}
