package com.example.commissionservice.domain.pojo;


import com.example.commissionservice.infra.entity.TypeCommissionEntity;

import java.math.BigDecimal;
import java.time.Instant;

public class CommissionDetail {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private BigDecimal price;
    TypeCommission typeCommission;
    Commission commission;

    public CommissionDetail(Long id, String ref, Instant createdAt, Instant updatedAt, BigDecimal price, TypeCommission typeCommission) {
        this.id = id;
        this.ref = ref;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.price = price;
        this.typeCommission = typeCommission;
    }

    public CommissionDetail( String ref, BigDecimal price, TypeCommission typeCommission) {
        this.ref = ref;
        this.price = price;
        this.typeCommission = typeCommission;
    }

    public CommissionDetail() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TypeCommission getTypeCommission() {
        return typeCommission;
    }

    public void setTypeCommission(TypeCommission typeCommission) {
        this.typeCommission = typeCommission;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "CommissionDetail{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", price=" + price +
                ", typeCommission=" + typeCommission +
                '}';
    }
}
