package com.trading.action.clientservice.domain.actionnaire.create;


import com.trading.action.clientservice.application.dto.ActionnaireDto;
import com.trading.action.clientservice.domain.core.AbstractProcessInput;
import com.trading.action.clientservice.domain.pojo.Actionnaire;

public class ActionnaireCreatenput extends AbstractProcessInput {
    Actionnaire actionnaire;

    public Actionnaire getActionnaire() {
        return actionnaire;
    }

    public void setActionnaire(Actionnaire actionnaire) {
        this.actionnaire = actionnaire;
    }
}
