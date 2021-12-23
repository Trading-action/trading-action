package com.example.commissionservice.application.dto;


import com.trading.clientservice.domain.compte.create.CompteCreateInput;

public class CompteDto {
    private String ref;
    private String refTypeCompte;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefTypeCompte() {
        return refTypeCompte;
    }

    public void setRefTypeCompte(String refTypeCompte) {
        this.refTypeCompte = refTypeCompte;
    }

   public static CompteCreateInput toCompteCreatenput(CompteDto compteDto) {
       CompteCreateInput compteCreatenput = new CompteCreateInput();
       compteCreatenput.setRef(compteDto.getRef());
       compteCreatenput.setRefCompteType(compteDto.getRefTypeCompte());

        return compteCreatenput;
    }
}
