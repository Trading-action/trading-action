package com.trading.clientservice.domain.portefeuille;


import com.trading.clientservice.domain.core.AbstractProcessImpl;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Action;
import com.trading.clientservice.domain.pojo.Portefeuille;
import com.trading.clientservice.infra.facade.ActionInfra;
import com.trading.clientservice.infra.facade.ActionnaireInfra;

import java.math.BigDecimal;
import java.util.ArrayList;
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
            result.addErrorMessage(actionnaireInfra.getMessage("actionnaire.not_founded"));
        }

        List<Action> actions =actionInfra.findByActionnaireUsername(portefeuilleInput.getUsername());

        if (actions.isEmpty()) {
            result.addErrorMessage(actionnaireInfra.getMessage("portefeuille.actions.empty"));
        }


    }

    @Override
    public void run(PortefeuilleInput portefeuilleInput, Result result) {
        List<String> entreprises = actionInfra.findEntreprises(portefeuilleInput.getUsername());
        List<Portefeuille> portefeuilles = new ArrayList<>();
        for (int i = 0; i <entreprises.size() ; i++) {
            List<Action> actions = actionInfra.findByRefEntrepriseAndActionnaireUsername(entreprises.get(i),portefeuilleInput.getUsername());
            Portefeuille portefeuille = actionnaireInfra.getPortefeuilles(actions);

            portefeuille.setPrix(actions.stream().map(Action::getPrix).reduce(BigDecimal.ZERO, BigDecimal::add));

            //TODO: get name of entreprise by ref
            portefeuille.setNomEnreprise("");

            //TODO: get  percentage of actions
            portefeuille.setPercentage(0);

            portefeuilles.add(portefeuille);
        }
        result.setOutput(portefeuilles);
    }

}
