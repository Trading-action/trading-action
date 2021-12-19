package com.trading.action.entreprise.application.dto;

import java.math.BigDecimal;

public class PriceDto {
    private BigDecimal prix;
    private String libelleEntreprise;

    public PriceDto() {
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getLibelleEntreprise() {
        return libelleEntreprise;
    }

    public void setLibelleEntreprise(String libelleEntreprise) {
        this.libelleEntreprise = libelleEntreprise;
    }
}
