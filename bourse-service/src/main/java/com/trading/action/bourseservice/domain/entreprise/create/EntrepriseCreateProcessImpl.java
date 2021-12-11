package com.trading.action.bourseservice.domain.entreprise.create;

import com.trading.action.bourseservice.domain.core.AbstractProcessImpl;
import com.trading.action.bourseservice.domain.core.Result;
import com.trading.action.bourseservice.domain.pojo.Entreprise;
import com.trading.action.bourseservice.infra.facade.EntrepriseInfra;

public class EntrepriseCreateProcessImpl extends AbstractProcessImpl<EntrepriseCreateInput> implements EntrepriseCreateProcess{

    private EntrepriseInfra entrepriseInfra;
    public EntrepriseCreateProcessImpl(EntrepriseInfra entrepriseInfra){
        this.entrepriseInfra = entrepriseInfra;
    }
    
    @Override
    public void validate(EntrepriseCreateInput entrepriseCreateInput, Result result) {
        Entreprise entreprise = entrepriseInfra.findByReference(entrepriseCreateInput.getReference());
        if(entreprise != null){
            result.addErrorMessage(entrepriseInfra.getMessage("entreprise.libelle.duplicated"));
        }
    }

    @Override
    public void run(EntrepriseCreateInput entrepriseCreateInput, Result result) {
        Entreprise entreprise = new Entreprise();
        entreprise.setAdress(entrepriseCreateInput.getAdress());
        entreprise.setDividende(entrepriseCreateInput.getDividende());
        entreprise.setNombreAction(entrepriseCreateInput.getNombreAction());
        entreprise.setReference(entrepriseCreateInput.getReference());
        entreprise.setLibelle(entrepriseCreateInput.getLibelle());
        entrepriseInfra.save(entreprise);
        result.addInfoMessage(entrepriseInfra.getMessage("entreprise.created"));
    }

}
