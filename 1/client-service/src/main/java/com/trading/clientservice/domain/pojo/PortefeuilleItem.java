package com.trading.clientservice.domain.pojo;

import java.util.List;

public class PortefeuilleItem {
    private  Action action;
    private List<PortefeuilleAction> portefeuilleActionList;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<PortefeuilleAction> getPortefeuilleActionList() {
        return portefeuilleActionList;
    }

    public void setPortefeuilleActionList(List<PortefeuilleAction> portefeuilleActionList) {
        this.portefeuilleActionList = portefeuilleActionList;
    }
}
