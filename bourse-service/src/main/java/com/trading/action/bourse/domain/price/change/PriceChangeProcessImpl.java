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
        }else{
            if(entreprise.getPrixAction() == null){
                result.addWarningMessage(entrepriseInfra.getMessage("entreprise.price.not_found"));
            }else{
                if(entreprise.getPrixAction().getPrix().compareTo(priceChangeInput.getPrix()) == 0){

                    result.addErrorMessage(priceInfra.getMessage("price.not.modified"));

                }
            }
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
        price = priceInfra.save(price);
        if(price == null){
            result.addErrorMessage(entrepriseInfra.getMessage("price.not_created"));
        }else{
            result.addInfoMessage(entrepriseInfra.getMessage("price.created"));
            entreprise.setPrixAction(price);
            entrepriseInfra.save(entreprise);
            result.addInfoMessage(entrepriseInfra.getMessage("entreprise.price.modified"));
        }
    }
    private EntrepriseInfra entrepriseInfra;
    private PriceInfra priceInfra;
    public PriceChangeProcessImpl(EntrepriseInfra entrepriseInfra, PriceInfra priceInfra){
        this.entrepriseInfra = entrepriseInfra;
        this.priceInfra = priceInfra;
    }

}
