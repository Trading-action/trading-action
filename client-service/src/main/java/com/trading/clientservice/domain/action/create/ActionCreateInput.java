package com.trading.clientservice.domain.action.create;


import com.trading.clientservice.domain.core.AbstractProcessInput;

import java.math.BigDecimal;

public class ActionCreateInput extends AbstractProcessInput {


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
}
