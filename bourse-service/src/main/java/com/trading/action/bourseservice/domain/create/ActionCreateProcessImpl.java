package com.trading.action.bourseservice.domain.create;


import com.trading.action.bourseservice.domain.core.AbstractProcessImpl;
import com.trading.action.bourseservice.domain.core.Result;
import com.trading.action.bourseservice.domain.pojo.Action;
import com.trading.action.bourseservice.domain.pojo.Actionnaire;
import com.trading.action.bourseservice.infra.facade.ActionInfra;
import com.trading.action.bourseservice.infra.required.ActionnaireService;

public class ActionCreateProcessImpl extends AbstractProcessImpl<ActionCreateInput> implements ActionCreateProcess {

    private ActionnaireService actionnaireService;
    private ActionInfra actionInfra;

    public ActionCreateProcessImpl(ActionnaireService actionnaireService, ActionInfra actionInfra) {
        this.actionnaireService = actionnaireService;
        this.actionInfra = actionInfra;
    }


    @Override
    public void validate(ActionCreateInput actionCreateInput, Result result) {

        Actionnaire actionnaire = actionnaireService.findByUsername(actionCreateInput.getUsernameActionnaire()).getOutput();
        Action action = actionInfra.findByReference(actionCreateInput.getReference());

        if (actionnaire == null) {
            result.addErrorMessage(actionInfra.getMessage("actionnaire.not_founded"));
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
        Actionnaire actionnaire = actionnaireService.findByUsername(actionCreateInput.getUsernameActionnaire()).getOutput();
        action.setUsernameActionnaire(actionnaire.getRef());

        actionInfra.save(action);
        result.addInfoMessage(actionInfra.getMessage("action.created"));
    }
}
