package com.trading.action.clientservice.domain.pojo;


import java.time.Instant;

public class CommissionDetail   {
   private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private String libelle;
    private  double pourcentage;
    private  boolean tva;
    private double minimal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public boolean isTva() {
        return tva;
    }

    public void setTva(boolean tva) {
        this.tva = tva;
    }

    public double getMinimal() {
        return minimal;
    }

    public void setMinimal(double minimal) {
        this.minimal = minimal;
    }
}
