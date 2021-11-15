package com.trading.action.clientservice.domain.actionnaire.create;


import com.trading.action.clientservice.domain.core.AbstractProcessImpl;
import com.trading.action.clientservice.domain.core.Result;
import com.trading.action.clientservice.domain.pojo.Actionnaire;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;

public class ActionnaireCreateProcessImpl extends AbstractProcessImpl<ActionnaireCreatenput> implements ActionnaireCreateProcess {



    public ActionnaireCreateProcessImpl(ActionnaireInfra actionnaireInfra){
        this.actionnaireInfra = actionnaireInfra;
    }


    private ActionnaireInfra actionnaireInfra;

    @Override
    public void validate(ActionnaireCreatenput actionnaireCreatenput, Result result) {
            String username = actionnaireCreatenput.getActionnaire().getUsername();
             Actionnaire actionnaire = actionnaireInfra.findByReference(username);
            if(actionnaire==null){
                result.addErrorMessage(actionnaireInfra.getMessage("actionnaire.not_founded"));
            }

    }

    @Override
    public void run(ActionnaireCreatenput actionnaireCreatenput, Result result) {

        actionnaireInfra.save(actionnaireCreatenput.getActionnaire());
        result.addInfoMessage(actionnaireInfra.getMessage("actionnaire.created"));
    }
}
