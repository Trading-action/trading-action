package com.trading.clientservice.domain.pojo;

import java.time.Instant;

public class PriceHistory {
    Instant date;
    String EntrepriseLibelle;

    public PriceHistory(Instant date, String entrepriseLibelle) {
        this.date = date;
        EntrepriseLibelle = entrepriseLibelle;
    }

    public PriceHistory() {
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getEntrepriseLibelle() {
        return EntrepriseLibelle;
    }

    public void setEntrepriseLibelle(String entrepriseLibelle) {
        EntrepriseLibelle = entrepriseLibelle;
    }
}
