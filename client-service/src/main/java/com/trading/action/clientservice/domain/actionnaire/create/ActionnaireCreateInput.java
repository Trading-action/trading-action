package com.trading.action.clientservice.domain.actionnaire.create;


import com.trading.action.clientservice.application.dto.ActionDto;
import com.trading.action.clientservice.application.dto.CompteDto;
import com.trading.action.clientservice.application.dto.TransactionDto;
import com.trading.action.clientservice.domain.core.AbstractProcessInput;

import java.time.Instant;
import java.util.List;

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
