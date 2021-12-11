package com.trading.action.bourseservice.application.dto;

import java.time.Instant;
import java.util.List;

public class CompteTypeDto {
   private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private List<CompteDto> comptes;

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

    public List<CompteDto> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteDto> comptes) {
        this.comptes = comptes;
    }
}
