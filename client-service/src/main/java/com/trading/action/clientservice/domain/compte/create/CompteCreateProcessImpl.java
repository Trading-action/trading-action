package com.trading.action.clientservice.domain.compte.create;


import com.trading.action.clientservice.domain.core.AbstractProcessImpl;
import com.trading.action.clientservice.domain.core.Result;
import com.trading.action.clientservice.domain.pojo.Compte;
import com.trading.action.clientservice.domain.pojo.CompteType;
import com.trading.action.clientservice.infra.facade.CompteInfra;
import com.trading.action.clientservice.infra.facade.CompteTypeInfra;

public class CompteCreateProcessImpl extends AbstractProcessImpl<CompteCreateInput> implements CompteCreateProcess {

    private CompteTypeInfra compteTypeInfra;
    private CompteInfra compteInfra;

    public CompteCreateProcessImpl(CompteInfra compteInfra,CompteTypeInfra compteTypeInfra) {
        this.compteTypeInfra = compteTypeInfra;
        this.compteInfra =compteInfra;
    }



    @Override
    public void validate(CompteCreateInput compteCreatenput, Result result) {

        Compte compte = compteInfra.findByRef(compteCreatenput.getRef());

        CompteType compteType =  compteTypeInfra.findByRef(compteCreatenput.getRefCompteType());

        if (compte != null) {
            result.addErrorMessage(compteInfra.getMessage("compte.already_exists"));
        }

        if (compteType == null) {
            result.addErrorMessage(compteInfra.getMessage("type_compte.not_found"));
        }
    }

    @Override
    public void run(CompteCreateInput compteCreatenput, Result result) {
        Compte compte = new Compte();
        compte.setRef(compteCreatenput.getRef());
        compte.setRefTypeCompte(compteCreatenput.getRefCompteType());
        compteInfra.save(compte);
        result.addInfoMessage(compteInfra.getMessage("compte.created"));
    }
}
