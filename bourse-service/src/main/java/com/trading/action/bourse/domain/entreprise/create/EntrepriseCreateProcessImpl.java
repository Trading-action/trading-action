package com.trading.action.bourse.domain.entreprise.create;

import com.trading.action.bourse.domain.core.AbstractProcessImpl;
import com.trading.action.bourse.domain.core.Result;
import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.infra.facade.EntrepriseInfra;

public class EntrepriseCreateProcessImpl extends AbstractProcessImpl<EntrepriseCreateInput> implements EntrepriseCreateProcess{

    private EntrepriseInfra entrepriseInfra;
    public EntrepriseCreateProcessImpl(EntrepriseInfra entrepriseInfra){
        this.entrepriseInfra = entrepriseInfra;
    }
    
    @Override
    public void validate(EntrepriseCreateInput entrepriseCreateInput, Result result) {
        String reference = entrepriseCreateInput.getEntreprise().getRef();
        Entreprise Entreprise = entrepriseInfra.findByReference(reference);
        if(Entreprise==null){
            result.addErrorMessage(entrepriseInfra.getMessage("Entreprise.not_founded"));
        }
    }

    @Override
    public void run(EntrepriseCreateInput entrepriseCreateInput, Result result) {
        entrepriseInfra.save(entrepriseCreateInput.getEntreprise());
        result.addInfoMessage(entrepriseInfra.getMessage("Entreprise.created"));
    }

}
