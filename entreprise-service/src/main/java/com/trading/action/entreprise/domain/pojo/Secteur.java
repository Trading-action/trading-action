package com.trading.action.entreprise.domain.pojo;

public class Secteur {
    private Long id;
    private String libelle;
    private String reference;

    public Secteur() {
    }

    public Secteur(Long id, String libelle, String reference) {
        this.id = id;
        this.libelle = libelle;
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
