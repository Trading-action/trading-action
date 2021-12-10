package com.trading.action.bourse.domain.pojo;

import java.time.Instant;
import java.util.List;

public class Commission {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private List<CommissionDetail> commissionDetails;
    private CommissionIntermediare commissionIntermediare;

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

    public List<CommissionDetail> getCommissionDetails() {
        return commissionDetails;
    }

    public void setCommissionDetails(List<CommissionDetail> commissionDetails) {
        this.commissionDetails = commissionDetails;
    }

    public CommissionIntermediare getCommissionIntermediare() {
        return commissionIntermediare;
    }

    public void setCommissionIntermediare(CommissionIntermediare commissionIntermediare) {
        this.commissionIntermediare = commissionIntermediare;
    }
}
