package com.trading.clientservice.domain.action.create;


import com.trading.clientservice.domain.core.AbstractProcessImpl;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Action;
import com.trading.clientservice.domain.pojo.Actionnaire;
import com.trading.clientservice.infra.facade.ActionInfra;
import com.trading.clientservice.infra.facade.ActionnaireInfra;

public class ActionCreateProcessImpl extends AbstractProcessImpl<ActionCreateInput> implements ActionCreateProcess {

    private ActionnaireInfra actionnaireInfra;
    private ActionInfra actionInfra;

    public ActionCreateProcessImpl(ActionnaireInfra actionnaireInfra, ActionInfra actionInfra) {
        this.actionnaireInfra = actionnaireInfra;
        this.actionInfra = actionInfra;
    }


    @Override
    public void validate(ActionCreateInput actionCreateInput, Result result) {

        Actionnaire actionnaire = actionnaireInfra.findByRef(actionCreateInput.getRefActionnaire());
        Action action = actionInfra.findByRef(actionCreateInput.getRef());

        if (actionnaire == null) {
            result.addErrorMessage(actionnaireInfra.getMessage("actionnaire.not_founded"));
        }

        if (action != null) {
            result.addErrorMessage(actionnaireInfra.getMessage("action.already_exists"));
        }
    }

    @Override
    public void run(ActionCreateInput actionCreateInput, Result result) {
        Action action = new Action();
        action.setPrix(actionCreateInput.getPrix());
        action.setRef(actionCreateInput.getRef());
        action.setInBourse(actionCreateInput.isInBourse());
        action.setRefEntreprise(actionCreateInput.getRefEntreprise());
        Actionnaire actionnaire = actionnaireInfra.findByRef(actionCreateInput.getRefActionnaire());
        action.setActionnaire(actionnaire);

        actionInfra.save(action);
        result.addInfoMessage(actionnaireInfra.getMessage("action.created"));
    }
}
