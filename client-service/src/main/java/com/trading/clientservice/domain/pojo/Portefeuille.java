package com.trading.clientservice.domain.pojo;

import java.math.BigDecimal;
import java.util.List;

public class Portefeuille {

    private double percentage;
    private  BigDecimal prix;
    private String nomEnreprise;
    private List<PortefeuilleItem> portefeuilleItemList;

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getNomEnreprise() {
        return nomEnreprise;
    }

    public void setNomEnreprise(String nomEnreprise) {
        this.nomEnreprise = nomEnreprise;
    }

    public List<PortefeuilleItem> getPortefeuilleItemList() {
        return portefeuilleItemList;
    }

    public void setPortefeuilleItemList(List<PortefeuilleItem> portefeuilleItemList) {
        this.portefeuilleItemList = portefeuilleItemList;
    }
}
