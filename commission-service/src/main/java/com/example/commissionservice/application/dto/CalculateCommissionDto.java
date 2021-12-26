package com.example.commissionservice.application.dto;

import com.example.commissionservice.application.converter.ActionCoverter;
import com.example.commissionservice.application.converter.CompteConverter;
import com.example.commissionservice.domain.commission.calculate.CommissionCalculateInput;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalculateCommissionDto {
    ActionDto action;
    CompteDto compte;
    String operationType;

    public static CommissionCalculateInput toCommissionCalculateInput(CalculateCommissionDto calculateCommissionDto) {
        CommissionCalculateInput commissionCalculateInput = new CommissionCalculateInput();
        ActionCoverter actionCoverter = new ActionCoverter();
        CompteConverter compteConverter = new CompteConverter();

        commissionCalculateInput.setOperationType(calculateCommissionDto.getOperationType());
        commissionCalculateInput.setAction(actionCoverter.convertFromDto(calculateCommissionDto.getAction()));
        commissionCalculateInput.setCompte(compteConverter.convertFromDto(calculateCommissionDto.getCompte()));

        return commissionCalculateInput;
    }
}
