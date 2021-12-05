package com.trading.action.bourse.application.dto;

import java.time.Instant;

public class CompteDto {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private CompteTypeDto typeCompte;
    private ActionnaireDto actionnaire;

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

    public CompteTypeDto getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(CompteTypeDto typeCompte) {
        this.typeCompte = typeCompte;
    }

    public ActionnaireDto getActionnaire() {
        return actionnaire;
    }

    public void setActionnaire(ActionnaireDto actionnaire) {
        this.actionnaire = actionnaire;
    }
}
