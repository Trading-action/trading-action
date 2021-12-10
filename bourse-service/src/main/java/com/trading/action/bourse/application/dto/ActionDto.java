package com.trading.action.bourse.application.dto;


import java.time.Instant;

public class ActionDto {

    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private ActionnaireDto actionnaire;
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

    public ActionnaireDto getActionnaire() {
        return actionnaire;
    }

    public void setActionnaire(ActionnaireDto actionnaire) {
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
