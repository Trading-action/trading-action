package com.trading.action.clientservice.application.dto;

import java.time.Instant;
import java.util.List;

public class CompteTypeDto {
    private String ref;
    private String libelle;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
