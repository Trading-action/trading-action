package com.trading.action.bourse.domain.entreprise.create;

import com.trading.action.bourse.domain.core.AbstractProcessInput;

import java.math.BigDecimal;

public class EntrepriseCreateInput extends AbstractProcessInput {
    private String reference;
    private String libelle;
    private String adress;
    private BigDecimal nombreAction;
    private BigDecimal dividende;

    public EntrepriseCreateInput() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public BigDecimal getNombreAction() {
        return nombreAction;
    }

    public void setNombreAction(BigDecimal nombreAction) {
        this.nombreAction = nombreAction;
    }

    public BigDecimal getDividende() {
        return dividende;
    }

    public void setDividende(BigDecimal dividende) {
        this.dividende = dividende;
    }
}
