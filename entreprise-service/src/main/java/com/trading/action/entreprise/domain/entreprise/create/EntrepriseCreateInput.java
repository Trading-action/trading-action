package com.trading.action.entreprise.domain.entreprise.create;

import com.trading.action.entreprise.domain.core.AbstractProcessInput;

import java.math.BigDecimal;

public class EntrepriseCreateInput extends AbstractProcessInput {
    private String libelle;
    private String adress;
    private BigDecimal nombreAction;
    private BigDecimal dividende;

    public EntrepriseCreateInput() {
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
