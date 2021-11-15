package com.trading.action.clientservice.domain.actionnaire.create;


import com.trading.action.clientservice.domain.core.AbstractProcessImpl;
import com.trading.action.clientservice.domain.core.Result;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;

public class ActionnaireCreateProcessImpl extends AbstractProcessImpl<ActionnaireCreatenput> implements ActionnaireCreateProcess {



    public ActionnaireCreateProcessImpl(ActionnaireInfra actionnaireInfra){
        this.actionnaireInfra = actionnaireInfra;
    }


    private ActionnaireInfra actionnaireInfra;

    @Override
    public void validate(ActionnaireCreatenput abstractProcessInput, Result result) {

    }

    @Override
    public void run(ActionnaireCreatenput abstractProcessInput, Result result) {

    }
}
