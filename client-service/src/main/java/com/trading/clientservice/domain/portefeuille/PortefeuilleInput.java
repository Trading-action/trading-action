package com.trading.clientservice.domain.portefeuille;


import com.trading.clientservice.domain.core.AbstractProcessInput;

public class PortefeuilleInput extends AbstractProcessInput {

     private String username;

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }
}
