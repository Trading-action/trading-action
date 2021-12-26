package com.example.commissionservice.domain.pojo;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Commission {
    private Long id;
    private String ref;
    private BigDecimal totalPrice;
    private Action action;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant dateCommission;
    private List<CommissionDetail> commissionDetails;

    public Commission(Long id, String ref, BigDecimal totalPrice, Action action, Instant createdAt, Instant updatedAt, Instant dateCommission, List<CommissionDetail> commissionDetails) {
        this.id = id;
        this.ref = ref;
        this.totalPrice = totalPrice;
        this.action = action;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dateCommission = dateCommission;
        this.commissionDetails = commissionDetails;
    }

    public Commission() {
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Instant getDateCommission() {
        return dateCommission;
    }

    public void setDateCommission(Instant dateCommission) {
        this.dateCommission = dateCommission;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<CommissionDetail> getCommissionDetails() {
        return commissionDetails;
    }

    public void setCommissionDetails(List<CommissionDetail> commissionDetails) {
        this.commissionDetails = commissionDetails;
    }

}
