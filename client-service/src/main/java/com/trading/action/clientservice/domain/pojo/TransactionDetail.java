package com.trading.action.clientservice.domain.pojo;


import java.math.BigDecimal;
import java.time.Instant;

public class TransactionDetail  {
   private Long id;
    private String ref;
    private  Instant createdAt;
    private  Instant updatedAt;
    private double qte;
    private BigDecimal prix;
    private Transaction transaction;
    private Intermediare intermediare;

    private Actionnaire vendeur;

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

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Intermediare getIntermediare() {
        return intermediare;
    }

    public void setIntermediare(Intermediare intermediare) {
        this.intermediare = intermediare;
    }

    public Actionnaire getVendeur() {
        return vendeur;
    }

    public void setVendeur(Actionnaire vendeur) {
        this.vendeur = vendeur;
    }
}
