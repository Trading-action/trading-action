package com.example.commissionservice.domain.pojo;

import java.time.Instant;

public class TypeCommission {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    String label;
    Instant applicationDateMin;
    Instant applicationDateMax;
    CompteType typeCompte;
    Float percentage;
    boolean tva;
    double minimal;
    String operationType;

    public TypeCommission(Long id, String ref, Instant createdAt, Instant updatedAt, String label, Instant applicationDateMin, Instant applicationDateMax, CompteType typeCompte, Float percentage, boolean tva, double minimal, String operationType) {
        this.id = id;
        this.ref = ref;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.label = label;
        this.applicationDateMin = applicationDateMin;
        this.applicationDateMax = applicationDateMax;
        this.typeCompte = typeCompte;
        this.percentage = percentage;
        this.tva = tva;
        this.minimal = minimal;
        this.operationType = operationType;
    }

    public TypeCommission() {

    }

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Instant getApplicationDateMin() {
        return applicationDateMin;
    }

    public void setApplicationDateMin(Instant applicationDateMin) {
        this.applicationDateMin = applicationDateMin;
    }

    public Instant getApplicationDateMax() {
        return applicationDateMax;
    }

    public void setApplicationDateMax(Instant applicationDateMax) {
        this.applicationDateMax = applicationDateMax;
    }

    public CompteType getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(CompteType typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public boolean isTva() {
        return tva;
    }

    public void setTva(boolean tva) {
        this.tva = tva;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public double getMinimal() {
        return minimal;
    }

    public void setMinimal(double minimal) {
        this.minimal = minimal;
    }

    @Override
    public String toString() {
        return "TypeCommission{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", label='" + label + '\'' +
                ", applicationDateMin=" + applicationDateMin +
                ", applicationDateMax=" + applicationDateMax +
                ", typeCompte=" + typeCompte +
                ", percentage=" + percentage +
                ", tva=" + tva +
                ", minimal=" + minimal +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
