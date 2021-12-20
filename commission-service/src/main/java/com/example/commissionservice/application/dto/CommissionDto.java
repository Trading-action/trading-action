package com.example.commissionservice.application.dto;

import com.example.commissionservice.domain.commission.create.CommissionCreateInput;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class CommissionDto {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private String refAction;
    private Instant dateCommission;
    private BigDecimal totalPrice;
    private List<CommissionDetailDto> commissionDetails;

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

    public String getRefAction() {
        return refAction;
    }

    public Instant getDateCommission() {
        return dateCommission;
    }

    public void setDateCommission(Instant dateCommission) {
        this.dateCommission = dateCommission;
    }

    public void setRefAction(String refAction) {
        this.refAction = refAction;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CommissionDetailDto> getCommissionDetails() {
        return commissionDetails;
    }

    public void setCommissionDetails(List<CommissionDetailDto> commissionDetails) {
        this.commissionDetails = commissionDetails;
    }


    public static CommissionCreateInput toCommissionCreateInput(CommissionDto commissionDto) {
        CommissionCreateInput commissionCreateInput = new CommissionCreateInput();
        commissionCreateInput.setRef(commissionDto.getRef());
        commissionCreateInput.setRefAction(commissionDto.getRefAction());
        commissionCreateInput.setDateCommission(commissionDto.getDateCommission());
        commissionCreateInput.setTotalPrice(commissionDto.getTotalPrice());
        return commissionCreateInput;
    }
}
