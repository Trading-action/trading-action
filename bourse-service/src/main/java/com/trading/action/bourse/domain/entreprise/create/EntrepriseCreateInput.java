package com.trading.action.bourse.domain.entreprise.create;

import com.trading.action.bourse.domain.core.AbstractProcessInput;
import com.trading.action.bourse.domain.pojo.Entreprise;

public class EntrepriseCreateInput extends AbstractProcessInput {

    private Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
