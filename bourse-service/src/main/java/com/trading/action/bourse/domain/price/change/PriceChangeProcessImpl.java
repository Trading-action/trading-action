package com.trading.action.bourse.domain.price.change;

import com.trading.action.bourse.domain.core.AbstractProcessImpl;
import com.trading.action.bourse.domain.core.Result;
import com.trading.action.bourse.infra.facade.EntrepriseInfra;
import com.trading.action.bourse.infra.facade.PriceInfra;

public class PriceChangeProcessImpl extends AbstractProcessImpl<PriceChangeInput> implements PriceChangeProcess {
    @Override
    public void validate(PriceChangeInput priceChangeInput, Result result) {

    }

    @Override
    public void run(PriceChangeInput priceChangeInput, Result result) {
//        Price price = new Price();
//        String priceRef = entreprise.getLibelle().substring(0,2)+"__"+ entreprise.getPrixAction().getPrix()+"__"+ new Date();
//        price.setEntreprise(entrepriseCreateInput);
//        price.setPrix(entrepriseCreateInput.getPrixAction());
//        price.setReference(priceRef);
//        priceInfra.save(price);
//        result.addInfoMessage(entrepriseInfra.getMessage("price.created"));
    }
    private EntrepriseInfra entrepriseInfra;
    private PriceInfra priceInfra;
    public PriceChangeProcessImpl(EntrepriseInfra entrepriseInfra, PriceInfra priceInfra){
        this.entrepriseInfra = entrepriseInfra;
        this.priceInfra = priceInfra;
    }

}
