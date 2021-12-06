package com.trading.action.clientservice.domain.pojo;

import java.math.BigDecimal;
import java.time.Instant;

public class PortefeuilleItem {

    private Instant date;
    private BigDecimal prix;
    private  BigDecimal prixPerteOrProfit;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public BigDecimal getPrixPerteOrProfit() {
        return prixPerteOrProfit;
    }

    public void setPrixPerteOrProfit(BigDecimal prixPerteOrProfit) {
        this.prixPerteOrProfit = prixPerteOrProfit;
    }
}
