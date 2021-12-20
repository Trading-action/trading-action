package com.trading.action.entreprise.application.dto;

import java.time.Instant;

public class PriceHistoryDto {
    Instant date;
    String EntrepriseLibelle;

    public PriceHistoryDto(Instant date, String entrepriseLibelle) {
        this.date = date;
        EntrepriseLibelle = entrepriseLibelle;
    }

    public PriceHistoryDto() {
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
