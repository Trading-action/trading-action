package com.trading.clientservice.domain.pojo;

import java.time.Instant;

public class Compte {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private String refTypeCompte;
    private String refActionnaire;

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

    public String getRefTypeCompte() {
        return refTypeCompte;
    }

    public void setRefTypeCompte(String refTypeCompte) {
        this.refTypeCompte = refTypeCompte;
    }

    public String getRefActionnaire() {
        return refActionnaire;
    }

    public void setRefActionnaire(String refActionnaire) {
        this.refActionnaire = refActionnaire;
    }
}
