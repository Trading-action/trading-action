package com.trading.clientservice.domain.pojo;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;


public class Transaction {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;

    private TransactionType typeTransaction;
    private TransactionEtat etatTransaction;

    private Commission commission;
    private List<TransactionDetail> transactionDetails;
    private Actionnaire acheteur;
    private BigDecimal prixTotal;
    private Date dateTransaction;

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

    public TransactionType getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TransactionType typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public TransactionEtat getEtatTransaction() {
        return etatTransaction;
    }

    public void setEtatTransaction(TransactionEtat etatTransaction) {
        this.etatTransaction = etatTransaction;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public List<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public Actionnaire getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Actionnaire acheteur) {
        this.acheteur = acheteur;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
