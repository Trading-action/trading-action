package com.example.commissionservice.application.converter;

import com.example.commissionservice.application.dto.CompteDto;
import com.example.commissionservice.application.utils.Converter;
import com.example.commissionservice.domain.pojo.Compte;

public class CompteConverter  extends Converter<Compte, CompteDto> {
    public CompteConverter() {
        super(CompteConverter::convertToDto, CompteConverter::convertToPojo);
    }

    private static CompteDto convertToDto(Compte compte) {
        return new CompteDto(compte.getId(), compte.getRef(), compte.getRefTypeCompte());
    }

    private static Compte convertToPojo(CompteDto compteDto) {
        return new Compte(compteDto.getId(), compteDto.getRef(), compteDto.getRefTypeCompte());
    }
}