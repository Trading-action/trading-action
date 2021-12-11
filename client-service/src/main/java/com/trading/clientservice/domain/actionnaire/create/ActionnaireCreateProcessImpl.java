package com.trading.clientservice.domain.actionnaire.create;


import com.trading.clientservice.domain.core.AbstractProcessImpl;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Actionnaire;
import com.trading.clientservice.domain.pojo.Compte;
import com.trading.clientservice.infra.facade.ActionnaireInfra;
import com.trading.clientservice.infra.facade.CompteInfra;

public class ActionnaireCreateProcessImpl extends AbstractProcessImpl<ActionnaireCreateInput> implements ActionnaireCreateProcess {

    private ActionnaireInfra actionnaireInfra;
    private CompteInfra compteInfra;

    public ActionnaireCreateProcessImpl(ActionnaireInfra actionnaireInfra, CompteInfra compteInfra) {
        this.actionnaireInfra = actionnaireInfra;
        this.compteInfra =compteInfra;
    }



    @Override
    public void validate(ActionnaireCreateInput actionnaireCreatenput, Result result) {
        String ref = actionnaireCreatenput
                .getRef();
        Actionnaire actionnaire = actionnaireInfra.findByRef(ref);

        Compte  compte =  compteInfra.findByRef(actionnaireCreatenput.getRefCompte());
        if (actionnaire != null) {
            result.addErrorMessage(actionnaireInfra.getMessage("actionnaire.already_exists"));
        }

        if (compte == null) {
            result.addErrorMessage(actionnaireInfra.getMessage("compte.not_found"));
        }
    }

    @Override
    public void run(ActionnaireCreateInput actionnaireCreatenput, Result result) {
        Actionnaire actionnaire = new Actionnaire();
        actionnaire.setRef(actionnaireCreatenput.getRef());
        actionnaire.setUsername(actionnaireCreatenput.getUsername());
        actionnaire.setRefCompte(actionnaireCreatenput.getRefCompte());
        actionnaireInfra.save(actionnaire);
        result.addInfoMessage(actionnaireInfra.getMessage("actionnaire.created"));
    }
}
