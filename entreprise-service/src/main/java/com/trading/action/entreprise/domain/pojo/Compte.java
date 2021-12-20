package com.trading.action.entreprise.domain.pojo;

import java.time.Instant;

public class Compte {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private CompteType typeCompte;
    private Actionnaire actionnaire;

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

    public CompteType getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(CompteType typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Actionnaire getActionnaire() {
        return actionnaire;
    }

    public void setActionnaire(Actionnaire actionnaire) {
        this.actionnaire = actionnaire;
    }
}
