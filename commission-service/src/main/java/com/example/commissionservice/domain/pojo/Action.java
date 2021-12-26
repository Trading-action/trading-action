package com.example.commissionservice.domain.pojo;


import java.math.BigDecimal;
import java.time.Instant;

public class Action {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean inBourse;
    private String refEntreprise;
    private BigDecimal prix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Action() {
    }

    public Action(String ref) {
        this.ref = ref;
    }

    public Action(Long id, String ref, Instant createdAt, Instant updatedAt, boolean inBourse, String refEntreprise, BigDecimal prix) {
        this.id = id;
        this.ref = ref;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.inBourse = inBourse;
        this.refEntreprise = refEntreprise;
        this.prix = prix;
    }


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
