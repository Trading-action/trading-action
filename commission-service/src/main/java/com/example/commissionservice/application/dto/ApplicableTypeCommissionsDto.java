package com.example.commissionservice.application.dto;

import com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions.FindApplicableTypeCommissionsInput;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicableTypeCommissionsDto {
    Instant operationDate;
    String operationType;
    String refTypeCompte;

    public static FindApplicableTypeCommissionsInput toFindApplicableTypeCommissionsInput(ApplicableTypeCommissionsDto applicableTypeCommissionsDto) {
        FindApplicableTypeCommissionsInput findApplicableTypeCommissionsInput = new FindApplicableTypeCommissionsInput();
        findApplicableTypeCommissionsInput.setOperationDate(applicableTypeCommissionsDto.getOperationDate());
        findApplicableTypeCommissionsInput.setOperationType(applicableTypeCommissionsDto.getOperationType());
        findApplicableTypeCommissionsInput.setRefTypeCompte(applicableTypeCommissionsDto.getRefTypeCompte());
        return findApplicableTypeCommissionsInput;
    }


}
