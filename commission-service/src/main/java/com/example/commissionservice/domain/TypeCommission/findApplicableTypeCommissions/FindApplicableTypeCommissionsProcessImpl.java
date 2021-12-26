package com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.entity.TypeCommissionEntity;
import com.example.commissionservice.infra.facade.TypeCommissionInfra;

import java.time.Instant;
import java.util.List;

public class FindApplicableTypeCommissionsProcessImpl extends AbstractProcessImpl<FindApplicableTypeCommissionsInput> implements FindApplicableTypeCommissionsProcess {

    private final TypeCommissionInfra typeCommissionInfra;

    public FindApplicableTypeCommissionsProcessImpl(TypeCommissionInfra typeCommissionInfra) {
        this.typeCommissionInfra = typeCommissionInfra;
    }

    @Override
    public void validate(FindApplicableTypeCommissionsInput findApplicableTypeCommissionsInput, Result result) {
        System.out.println("FindApplicableTypeCommissionsInput : operationDate: " + findApplicableTypeCommissionsInput.getOperationType() + ", operationType: " + findApplicableTypeCommissionsInput.getOperationType() + ", refTypeCompte: " + findApplicableTypeCommissionsInput.getRefTypeCompte());

        System.out.println();
        // Validation du ref de type compte
        if (findApplicableTypeCommissionsInput.getRefTypeCompte() == null || findApplicableTypeCommissionsInput.getRefTypeCompte() == "") {
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.NullRefTypeCompte"));
        }

        // Validation de la date d'opération
        if (findApplicableTypeCommissionsInput.getOperationDate() == null) {
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.NullOperationDate"));
        }

        // Validation du d'opération
        if (findApplicableTypeCommissionsInput.getOperationType() == null || findApplicableTypeCommissionsInput.getOperationType() == "") {
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.NullOperationType"));
        }

    }

    @Override
    public void run(FindApplicableTypeCommissionsInput findApplicableTypeCommissionsInput, Result result) {
        List<TypeCommission> typeCommissionList = typeCommissionInfra.findApplicableTypeCommissionEntities(findApplicableTypeCommissionsInput.getOperationDate(), findApplicableTypeCommissionsInput.getOperationType(), findApplicableTypeCommissionsInput.getRefTypeCompte());
        result.setOutput(typeCommissionList);
    }
}
