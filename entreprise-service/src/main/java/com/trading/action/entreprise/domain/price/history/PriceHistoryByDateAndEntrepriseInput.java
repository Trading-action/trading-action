package com.trading.action.entreprise.domain.price.history;

import com.trading.action.entreprise.domain.core.AbstractProcessInput;

import java.time.Instant;

public class PriceHistoryByDateAndEntrepriseInput extends AbstractProcessInput {
    Instant date;
    String EntrepriseLibelle;

    public PriceHistoryByDateAndEntrepriseInput() {
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
