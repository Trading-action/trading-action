package com.trading.clientservice.domain.pojo;


import java.math.BigDecimal;
import java.time.Instant;

public class Action {
    private String reference;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean inBourse;
    private String referenceEntreprise;
    private BigDecimal prix;
    private String referenceActionnaire;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public boolean isInBourse() {
        return inBourse;
    }

    public void setInBourse(boolean inBourse) {
        this.inBourse = inBourse;
    }

    public String getReferenceEntreprise() {
        return referenceEntreprise;
    }

    public void setReferenceEntreprise(String referenceEntreprise) {
        this.referenceEntreprise = referenceEntreprise;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getReferenceActionnaire() {
        return referenceActionnaire;
    }

    public void setReferenceActionnaire(String referenceActionnaire) {
        this.referenceActionnaire = referenceActionnaire;
    }
}
