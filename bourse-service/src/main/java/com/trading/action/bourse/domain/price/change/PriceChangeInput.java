package com.trading.action.bourse.domain.price.change;

import com.trading.action.bourse.domain.core.AbstractProcessInput;

import java.math.BigDecimal;

public class PriceChangeInput extends AbstractProcessInput {
    private BigDecimal prix;
    private String referenceEntreprise;

    public PriceChangeInput() {
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getReferenceEntreprise() {
        return referenceEntreprise;
    }

    public void setReferenceEntreprise(String referenceEntreprise) {
        this.referenceEntreprise = referenceEntreprise;
    }
}
