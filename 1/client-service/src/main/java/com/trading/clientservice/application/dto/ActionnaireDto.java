package com.trading.clientservice.application.dto;


import com.trading.clientservice.domain.actionnaire.create.ActionnaireCreateInput;

public class ActionnaireDto {
    private String ref;
    private String refCompte;
    private String username;

    public String getRefCompte() {
        return refCompte;
    }

    public void setRefCompte(String refCompte) {
        this.refCompte = refCompte;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }




    public static ActionnaireCreateInput toActionnaireCreatenput(ActionnaireDto actionnaireDto) {
        ActionnaireCreateInput actionnaireCreatenput = new ActionnaireCreateInput();
        actionnaireCreatenput.setRef(actionnaireDto.getRef());
        actionnaireCreatenput.setUsername(actionnaireDto.getUsername());
        actionnaireCreatenput.setRefCompte(actionnaireDto.getRefCompte());
        return actionnaireCreatenput;
    }


}
