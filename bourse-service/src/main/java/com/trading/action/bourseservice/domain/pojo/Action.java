package com.trading.action.bourseservice.domain.pojo;


import java.math.BigDecimal;
import java.time.Instant;

public class Action {

    private String reference;
    private Instant createdAt;
    private Instant updatedAt;
    String usernameActionnaire;
    boolean inBourse;
    String referenceEntreprise;
    BigDecimal prix;

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

    public String getUsernameActionnaire() {
        return usernameActionnaire;
    }

    public void setUsernameActionnaire(String usernameActionnaire) {
        this.usernameActionnaire = usernameActionnaire;
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
}
