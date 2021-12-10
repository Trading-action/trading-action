package com.trading.action.bourse.domain.pojo;

import java.math.BigDecimal;
import java.time.Instant;
public class Entreprise {
    private Long id;
    private String reference;
    private Instant createdAt;
    private Instant updatedAt;
    private String libelle;
    private String adress;
    private Price prixAction;
    private BigDecimal nombreAction;
    private BigDecimal dividende;

    public Entreprise() {
    }

    public Entreprise(String reference, String libelle, String adress, Price prixAction, BigDecimal nombreAction, BigDecimal dividende) {
        this.reference = reference;
        this.libelle = libelle;
        this.adress = adress;
        this.prixAction = prixAction;
        this.nombreAction = nombreAction;
        this.dividende = dividende;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
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

    public Price getPrixAction() {
        return prixAction;
    }

    public void setPrixAction(Price prixAction) {
        this.prixAction = prixAction;
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
