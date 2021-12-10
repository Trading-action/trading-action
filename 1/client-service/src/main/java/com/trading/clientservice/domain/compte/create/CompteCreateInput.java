package com.trading.clientservice.domain.compte.create;


import com.trading.clientservice.domain.core.AbstractProcessInput;

public class CompteCreateInput extends AbstractProcessInput {

     private String ref;
     private String  refCompteType;
     private String libelle;

     public String getRefCompteType() {
          return refCompteType;
     }

     public void setRefCompteType(String refCompteType) {
          this.refCompteType = refCompteType;
     }

     public String getRef() {
          return ref;
     }

     public void setRef(String ref) {
          this.ref = ref;
     }

     public String getLibelle() {
          return libelle;
     }

     public void setLibelle(String libelle) {
          this.libelle = libelle;
     }
}
