package com.trading.action.entreprise.application.dto;

import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateInput;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class EntrepriseDto {
    private String libelle;
    private String adress;
    private BigDecimal nombreAction;
    private BigDecimal dividende;

    public EntrepriseDto() {
    }

    public EntrepriseDto(String libelle, String adress, BigDecimal nombreAction, BigDecimal dividende) {
        this.libelle = libelle;
        this.adress = adress;
        this.nombreAction = nombreAction;
        this.dividende = dividende;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public BigDecimal getNombreAction() {
        return nombreAction;
    }

    public void setNombreAction(BigDecimal nombreAction) {
        this.nombreAction = nombreAction;
    }

    public BigDecimal getDividende() {
        return dividende;
    }

    public void setDividende(BigDecimal dividende) {
        this.dividende = dividende;
    }

    @Override
    public String toString() {
        return "EntrepriseDto{" +
                ", libelle='" + libelle + '\'' +
                ", adress='" + adress + '\'' +
                ", nombreAction=" + nombreAction +
                ", dividende=" + dividende +
                '}';
    }

    public static EntrepriseCreateInput toEntrepriseCreateInput(EntrepriseDto entrepriseDto){
        EntrepriseCreateInput entrepriseCreateInput = new EntrepriseCreateInput();
        if(entrepriseCreateInput != null) BeanUtils.copyProperties(entrepriseDto, entrepriseCreateInput);
        return entrepriseCreateInput;
    }
}
