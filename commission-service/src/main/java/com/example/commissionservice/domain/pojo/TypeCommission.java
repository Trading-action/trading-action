package com.example.commissionservice.domain.pojo;

import java.time.Instant;

public class TypeCommission {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private String label;
    private Instant applicationDateMin;
    private Instant applicationDateMax;
    private Compte compte;
    private Float percentage;
    private boolean tva;
    private TransactionType operationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
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

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
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

    public TransactionType getOperationType() {
        return operationType;
    }

    public void setOperationType(TransactionType operationType) {
        this.operationType = operationType;
    }
}
