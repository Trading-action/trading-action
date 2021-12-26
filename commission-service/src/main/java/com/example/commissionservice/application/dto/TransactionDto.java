package com.example.commissionservice.application.dto;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;


public class TransactionDto {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;

    private TransactionType typeTransaction;
    private TransactionEtatDto etatTransaction;

    private CommissionDto commission;
    private List<TransactionDetailDto> transactionDetails;
    private ActionnaireDto acheteur;
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

    public TransactionEtatDto getEtatTransaction() {
        return etatTransaction;
    }

    public void setEtatTransaction(TransactionEtatDto etatTransaction) {
        this.etatTransaction = etatTransaction;
    }

    public CommissionDto getCommission() {
        return commission;
    }

    public void setCommission(CommissionDto commission) {
        this.commission = commission;
    }

    public List<TransactionDetailDto> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetailDto> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public ActionnaireDto getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(ActionnaireDto acheteur) {
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
