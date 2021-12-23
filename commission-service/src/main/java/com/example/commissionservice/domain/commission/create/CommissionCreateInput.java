package com.example.commissionservice.domain.commission.create;

import com.example.commissionservice.domain.core.AbstractProcessInput;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Test
 */
public class CommissionCreateInput extends AbstractProcessInput {
    private String ref;
    private String refAction;
    private Instant dateCommission;
    private BigDecimal totalPrice;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefAction() {
        return refAction;
    }

    public void setRefAction(String refAction) {
        this.refAction = refAction;
    }

    public Instant getDateCommission() {
        return dateCommission;
    }

    public void setDateCommission(Instant dateCommission) {
        this.dateCommission = dateCommission;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
