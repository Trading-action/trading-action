package com.trading.action.bourse.domain.price.change;

import com.trading.action.bourse.domain.core.AbstractProcessImpl;
import com.trading.action.bourse.domain.core.Result;
import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.domain.pojo.Price;
import com.trading.action.bourse.infra.facade.EntrepriseInfra;
import com.trading.action.bourse.infra.facade.PriceInfra;

import java.util.Date;

public class PriceChangeProcessImpl extends AbstractProcessImpl<PriceChangeInput> implements PriceChangeProcess {
    @Override
    public void validate(PriceChangeInput priceChangeInput, Result result) {
        Entreprise entreprise = entrepriseInfra.findByReference(priceChangeInput.getReferenceEntreprise());
        if(entreprise == null){
            result.addErrorMessage(entrepriseInfra.getMessage("entreprise.not_found"));
        }
    }

    @Override
    public void run(PriceChangeInput priceChangeInput, Result result) {
        Price price = new Price();
        Entreprise entreprise = entrepriseInfra.findByReference(priceChangeInput.getReferenceEntreprise());
        String priceRef = entreprise.getLibelle().substring(0,2)+ "__" + new Date();
        price.setEntreprise(entreprise);
        price.setPrix(priceChangeInput.getPrix());
        price.setReference(priceRef);
        priceInfra.save(price);
        result.addInfoMessage(entrepriseInfra.getMessage("price.created"));
    }
    private EntrepriseInfra entrepriseInfra;
    private PriceInfra priceInfra;
    public PriceChangeProcessImpl(EntrepriseInfra entrepriseInfra, PriceInfra priceInfra){
        this.entrepriseInfra = entrepriseInfra;
        this.priceInfra = priceInfra;
    }

}
