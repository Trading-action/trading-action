package com.example.commissionservice.application.dto;


import java.math.BigDecimal;
import java.time.Instant;

public class TransactionDetailDto  {
   private Long id;
    private String ref;
    private  Instant createdAt;
    private  Instant updatedAt;
    private double qte;
    private BigDecimal prix;
    private TransactionDto transaction;
    private IntermediareDto intermediare;

    private ActionnaireDto vendeur;

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

    public TransactionDto getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDto transaction) {
        this.transaction = transaction;
    }

    public IntermediareDto getIntermediare() {
        return intermediare;
    }

    public void setIntermediare(IntermediareDto intermediare) {
        this.intermediare = intermediare;
    }

    public ActionnaireDto getVendeur() {
        return vendeur;
    }

    public void setVendeur(ActionnaireDto vendeur) {
        this.vendeur = vendeur;
    }
}
