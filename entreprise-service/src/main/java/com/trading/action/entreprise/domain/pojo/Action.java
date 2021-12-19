package com.trading.action.entreprise.domain.pojo;


import java.time.Instant;

public class Action {

    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private Actionnaire actionnaire;
    private boolean inBourse;
    private String refEntreprise;

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

    public Actionnaire getActionnaire() {
        return actionnaire;
    }

    public void setActionnaire(Actionnaire actionnaire) {
        this.actionnaire = actionnaire;
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
