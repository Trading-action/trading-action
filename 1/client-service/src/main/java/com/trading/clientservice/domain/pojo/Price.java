package com.trading.clientservice.domain.pojo;

import java.math.BigDecimal;
import java.time.Instant;

public class Price {
   private Instant createdAt;
  private   BigDecimal prix;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
