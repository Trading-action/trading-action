package com.trading.clientservice.domain.pojo;


import java.math.BigDecimal;
import java.time.Instant;

public class Action {
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean inBourse;
    private String refEntreprise;
    private BigDecimal prix;


    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
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

    public boolean isInBourse() {
        return inBourse;
    }

    public void setInBourse(boolean inBourse) {
        this.inBourse = inBourse;
    }

    public String getRefEntreprise() {
        return refEntreprise;
    }

    public void setRefEntreprise(String refEntreprise) {
        this.refEntreprise = refEntreprise;
    }
}
