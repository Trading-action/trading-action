package com.trading.clientservice.domain.actionnaire.create;


import com.trading.clientservice.domain.core.AbstractProcessInput;

public class ActionnaireCreateInput extends AbstractProcessInput {

     private String ref;
     private String username;
     private String refCompte;

     public String getRefCompte() {
          return refCompte;
     }

     public void setRefCompte(String refCompte) {
          this.refCompte = refCompte;
     }

     public String getRef() {
          return ref;
     }

     public void setRef(String ref) {
          this.ref = ref;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }
}
