package com.trading.action.entreprise.domain.entreprise.create;

import com.trading.action.entreprise.domain.core.AbstractProcessImpl;
import com.trading.action.entreprise.domain.core.Result;
import com.trading.action.entreprise.domain.pojo.Entreprise;
import com.trading.action.entreprise.infra.facade.EntrepriseInfra;

public class EntrepriseCreateProcessImpl extends AbstractProcessImpl<EntrepriseCreateInput> implements EntrepriseCreateProcess{

    private EntrepriseInfra entrepriseInfra;
    public EntrepriseCreateProcessImpl(EntrepriseInfra entrepriseInfra){
        this.entrepriseInfra = entrepriseInfra;
    }

    @Override
    public void validate(EntrepriseCreateInput entrepriseCreateInput, Result result) {
        Entreprise entrepriseLibelle = entrepriseInfra.findByLibelle(entrepriseCreateInput.getLibelle());
        if(entrepriseLibelle != null){
            result.addErrorMessage(entrepriseInfra.getMessage("entreprise.libelle.duplicated"));
        }
    }

    @Override
    public void run(EntrepriseCreateInput entrepriseCreateInput, Result result) {
        Entreprise entreprise = new Entreprise();
        entreprise.setAdress(entrepriseCreateInput.getAdress());
        entreprise.setDividende(entrepriseCreateInput.getDividende());
        entreprise.setNombreAction(entrepriseCreateInput.getNombreAction());
        entreprise.setLibelle(entrepriseCreateInput.getLibelle());
        entreprise.setReference(entrepriseCreateInput.getLibelle()+entreprise.getAdress().split(" ")[0]);
        entrepriseInfra.save(entreprise);
        result.addInfoMessage(entrepriseInfra.getMessage("entreprise.created"));
    }

}
