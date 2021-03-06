package com.trading.action.bourseservice.domain.pojo;

import java.math.BigDecimal;

public class Price {
    Long id;
    String reference;
    Entreprise entreprise;
    BigDecimal prix;

    public String getReference() {
        return reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
