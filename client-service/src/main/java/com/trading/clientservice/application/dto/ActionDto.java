package com.trading.clientservice.application.dto;


import com.trading.clientservice.domain.action.create.ActionCreateInput;
import com.trading.clientservice.domain.actionnaire.create.ActionnaireCreateInput;

import java.math.BigDecimal;

public class ActionDto {

    private String ref;
    private String refActionnaire;
    private boolean inBourse;
    private String refEntreprise;
    private BigDecimal prix;

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefActionnaire() {
        return refActionnaire;
    }

    public void setRefActionnaire(String refActionnaire) {
        this.refActionnaire = refActionnaire;
    }

    public boolean isInBourse() {
        return inBourse;
    }

    public void setInBourse(boolean inBourse) {
        this.inBourse = inBourse;
    }

    public String getRefEntreprise() {
        return refEntreprise;
    }

    public void setRefEntreprise(String refEntreprise) {
        this.refEntreprise = refEntreprise;
    }

    public static ActionCreateInput toActionCreatenput(ActionDto actionDto) {
        ActionCreateInput actionCreatenput = new ActionCreateInput();
        actionCreatenput.setRef(actionDto.getRef());
        actionCreatenput.setInBourse(actionDto.isInBourse());
        actionCreatenput.setRefActionnaire(actionDto.getRefActionnaire());
        actionCreatenput.setPrix(actionDto.getPrix());
        actionCreatenput.setRefEntreprise(actionDto.getRefEntreprise());
        return actionCreatenput;
    }
}
