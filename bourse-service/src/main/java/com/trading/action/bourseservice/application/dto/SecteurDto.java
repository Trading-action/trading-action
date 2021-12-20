package com.trading.action.entreprise.application.dto;

public class SecteurDto {
    String libelle;

    public SecteurDto(String libelle) {
        this.libelle = libelle;
    }

    public SecteurDto() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
