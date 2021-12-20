package com.trading.action.entreprise.domain.price.change;

import com.trading.action.entreprise.domain.core.AbstractProcessInput;

import java.math.BigDecimal;

public class PriceChangeInput extends AbstractProcessInput {
    private BigDecimal prix;
    private String libelleEntreprise;

    public PriceChangeInput() {
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
