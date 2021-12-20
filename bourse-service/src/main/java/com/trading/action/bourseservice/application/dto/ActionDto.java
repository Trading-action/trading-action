package com.trading.action.bourseservice.application.dto;



import com.trading.action.bourseservice.domain.create.ActionCreateInput;

import java.math.BigDecimal;
import java.time.Instant;

public class ActionDto {

    private String reference;
    String usernameActionnaire;
    boolean inBourse;
    String referenceEntreprise;
    BigDecimal prix;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUsernameActionnaire() {
        return usernameActionnaire;
    }

    public void setUsernameActionnaire(String usernameActionnaire) {
        this.usernameActionnaire = usernameActionnaire;
    }

    public boolean isInBourse() {
        return inBourse;
    }

    public void setInBourse(boolean inBourse) {
        this.inBourse = inBourse;
    }

    public String getReferenceEntreprise() {
        return referenceEntreprise;
    }

    public void setReferenceEntreprise(String referenceEntreprise) {
        this.referenceEntreprise = referenceEntreprise;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public static ActionCreateInput toActionCreatenput(ActionDto actionDto) {
        ActionCreateInput actionCreatenput = new ActionCreateInput();
        actionCreatenput.setReference(actionDto.getReference());
        actionCreatenput.setInBourse(actionDto.isInBourse());
        actionCreatenput.setUsernameActionnaire(actionDto.getUsernameActionnaire());
        actionCreatenput.setPrix(actionDto.getPrix());
        actionCreatenput.setReferenceEntreprise(actionDto.getReferenceEntreprise());
        return actionCreatenput;
    }
}
