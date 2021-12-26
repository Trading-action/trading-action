package com.trading.clientservice.domain.portefeuille;


import com.trading.clientservice.domain.core.AbstractProcessImpl;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Action;
import com.trading.clientservice.domain.pojo.Portefeuille;
import com.trading.clientservice.infra.facade.ActionnaireInfra;
import com.trading.clientservice.infra.required.BourseService;
import com.trading.clientservice.infra.required.EntrepriseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PortefeuilleProcessImpl extends AbstractProcessImpl<PortefeuilleInput> implements PortefeuilleProcess {

    private final ActionnaireInfra actionnaireInfra;
    private final EntrepriseService entrepriseService;
    private final BourseService bourseService;

    public PortefeuilleProcessImpl( BourseService bourseService,EntrepriseService entrepriseService, ActionnaireInfra actionnaireInfra) {
        this.actionnaireInfra = actionnaireInfra;
        this.entrepriseService = entrepriseService;
        this.bourseService = bourseService;
    }


    @Override
    public void validate(PortefeuilleInput portefeuilleInput, Result result) {

        if (actionnaireInfra.findByUsername(portefeuilleInput.getUsername()) == null) {
            result.addErrorMessage(actionnaireInfra.getMessage("actionnaire.not_founded"));
        }
    }

    @Override
    public void run(PortefeuilleInput portefeuilleInput, Result result) {
        List<String> entreprises = bourseService.findEntreprisesByUsernameActionnaire(portefeuilleInput.getUsername());
        List<Portefeuille> portefeuilles = new ArrayList<>();
        for (int i = 0; i < entreprises.size(); i++) {
            List<Action> actions = bourseService.findByReferenceEntrepriseAndAndUsernameActionnaire(entreprises.get(i), portefeuilleInput.getUsername());
            Portefeuille portefeuille = actionnaireInfra.getPortefeuilles(actions);
            if (portefeuille != null) {

                portefeuille.setPrix(actions.stream().map(Action::getPrix).reduce(BigDecimal.ZERO, BigDecimal::add));

                portefeuille.setNomEnreprise(actions.get(0).getReferenceEntreprise());

                portefeuille.setPercentage(entrepriseService.getSharePercentage(actions.get(0).getReferenceEntreprise(), new BigDecimal(actions.size())).getOutput().doubleValue());

                portefeuilles.add(portefeuille);
            }

        }
        result.setOutput(portefeuilles);
    }

}
