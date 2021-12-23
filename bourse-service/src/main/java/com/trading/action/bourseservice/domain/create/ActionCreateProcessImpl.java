package com.trading.action.bourseservice.domain.create;


import com.trading.action.bourseservice.domain.core.AbstractProcessImpl;
import com.trading.action.bourseservice.domain.core.Result;
import com.trading.action.bourseservice.domain.pojo.Action;
import com.trading.action.bourseservice.domain.pojo.Actionnaire;
import com.trading.action.bourseservice.domain.pojo.Entreprise;
import com.trading.action.bourseservice.infra.facade.ActionInfra;
import com.trading.action.bourseservice.infra.required.ActionnaireService;
import com.trading.action.bourseservice.infra.required.EntrepriseService;

public class ActionCreateProcessImpl extends AbstractProcessImpl<ActionCreateInput> implements ActionCreateProcess {

    private ActionnaireService actionnaireService;
    private ActionInfra actionInfra;
    private EntrepriseService entrepriseService;

    public ActionCreateProcessImpl(EntrepriseService entrepriseService,ActionnaireService actionnaireService, ActionInfra actionInfra) {
        this.actionnaireService = actionnaireService;
        this.actionInfra = actionInfra;
        this.entrepriseService=entrepriseService;
    }


    @Override
    public void validate(ActionCreateInput actionCreateInput, Result result) {

        Actionnaire actionnaire = actionnaireService.findByUsername(actionCreateInput.getUsernameActionnaire());
        Action action = actionInfra.findByReference(actionCreateInput.getReference());
        Result<Entreprise,Entreprise> rsEntreprise = entrepriseService.findByReference(actionCreateInput.getReferenceEntreprise());

        if (actionnaire == null) {
            result.addErrorMessage(actionInfra.getMessage("actionnaire.not_founded"));
        }

        if (rsEntreprise.getOutput() == null) {
            result.addErrorMessage(actionInfra.getMessage("entreprise.not_founded"));
        }

        if (action != null) {
            result.addErrorMessage(actionInfra.getMessage("action.already_exists"));
        }
    }

    @Override
    public void run(ActionCreateInput actionCreateInput, Result result) {
        Action action = new Action();
        action.setPrix(actionCreateInput.getPrix());
        action.setReference(actionCreateInput.getReference());
        action.setInBourse(actionCreateInput.isInBourse());
        action.setReferenceEntreprise(actionCreateInput.getReferenceEntreprise());
        Actionnaire actionnaire = actionnaireService.findByUsername(actionCreateInput.getUsernameActionnaire());
        action.setUsernameActionnaire(actionnaire.getRef());

        actionInfra.save(action);
        result.addInfoMessage(actionInfra.getMessage("action.created"));
    }
}
