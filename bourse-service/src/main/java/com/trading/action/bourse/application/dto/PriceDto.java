package com.trading.action.bourse.application.dto;

import java.math.BigDecimal;

public class PriceDto {
    private BigDecimal prix;
    private String referenceEntreprise;

    public PriceDto() {
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
