package com.example.commissionservice.application.dto;


import com.trading.clientservice.domain.compte.create.CompteCreateInput;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompteDto {
    Long id;
    String ref;
    String refTypeCompte;

    public static CompteCreateInput toCompteCreatenput(CompteDto compteDto) {
        CompteCreateInput compteCreatenput = new CompteCreateInput();
        compteCreatenput.setRef(compteDto.getRef());
        compteCreatenput.setRefCompteType(compteDto.getRefTypeCompte());
        return compteCreatenput;
    }
}
