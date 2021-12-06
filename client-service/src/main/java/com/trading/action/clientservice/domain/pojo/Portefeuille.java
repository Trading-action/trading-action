package com.trading.action.clientservice.domain.pojo;

import java.util.List;

public class Portefeuille {
    private  Action action;
    private List<PortefeuilleItem> portefeuilleItemList;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<PortefeuilleItem> getPortefeuilleItemList() {
        return portefeuilleItemList;
    }

    public void setPortefeuilleItemList(List<PortefeuilleItem> portefeuilleItemList) {
        this.portefeuilleItemList = portefeuilleItemList;
    }
}
