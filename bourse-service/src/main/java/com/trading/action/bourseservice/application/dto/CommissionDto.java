package com.trading.action.bourseservice.application.dto;

import java.time.Instant;
import java.util.List;

public class CommissionDto {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private List<CommissionDetailDto> commissionDetails;
    private CommissionIntermediareDto commissionIntermediare;

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

    public List<CommissionDetailDto> getCommissionDetails() {
        return commissionDetails;
    }

    public void setCommissionDetails(List<CommissionDetailDto> commissionDetails) {
        this.commissionDetails = commissionDetails;
    }

    public CommissionIntermediareDto getCommissionIntermediare() {
        return commissionIntermediare;
    }

    public void setCommissionIntermediare(CommissionIntermediareDto commissionIntermediare) {
        this.commissionIntermediare = commissionIntermediare;
    }
}
