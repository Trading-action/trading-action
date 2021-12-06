package com.trading.action.clientservice.domain.portefeuille;


import com.trading.action.clientservice.domain.core.AbstractProcessImpl;
import com.trading.action.clientservice.domain.core.Result;
import com.trading.action.clientservice.domain.pojo.Action;
import com.trading.action.clientservice.domain.pojo.Actionnaire;
import com.trading.action.clientservice.domain.pojo.Compte;
import com.trading.action.clientservice.domain.pojo.Portefeuille;
import com.trading.action.clientservice.infra.facade.ActionInfra;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;
import com.trading.action.clientservice.infra.facade.CompteInfra;

import java.util.List;

public class PortefeuilleProcessImpl extends AbstractProcessImpl<PortefeuilleInput> implements PortefeuilleProcess {

    private ActionInfra actionInfra;
    private ActionnaireInfra actionnaireInfra;

    public PortefeuilleProcessImpl(ActionInfra actionInfra, ActionnaireInfra actionnaireInfra) {
        this.actionInfra = actionInfra;
        this.actionnaireInfra = actionnaireInfra;
    }


    @Override
    public void validate(PortefeuilleInput portefeuilleInput, Result result) {

        if (actionnaireInfra.findByUsername(portefeuilleInput.getUsername()) == null) {
            result.addErrorMessage(actionnaireInfra.getMessage("actionnaire.noy_found"));
        }

        List<Action> actions =actionInfra.findByActionnaireUsername(portefeuilleInput.getUsername());

        if (actions.isEmpty()) {
            result.addErrorMessage(actionnaireInfra.getMessage("portefeuille.actions.empty"));
        }


    }

    @Override
    public void run(PortefeuilleInput portefeuilleInput, Result result) {
        List<Portefeuille> portefeuilles = actionnaireInfra.getPortefeuilles(actionInfra.findByActionnaireUsername(portefeuilleInput.getUsername()));
        result.setOutput(portefeuilles);
    }

}
