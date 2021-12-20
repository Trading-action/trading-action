package com.trading.action.bourseservice.domain.create;


import com.trading.action.bourseservice.domain.core.AbstractProcessInput;

import java.math.BigDecimal;

public class ActionCreateInput extends AbstractProcessInput {


     private String reference;
     private String usernameActionnaire;
     private boolean inBourse;
     private String referenceEntreprise;
     private BigDecimal prix;

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
}
