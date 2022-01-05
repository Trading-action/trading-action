package com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.entity.TypeCommissionEntity;
import com.example.commissionservice.infra.facade.TypeCommissionInfra;
import com.example.commissionservice.infra.required.ClientService;

import java.time.Instant;
import java.util.List;

public class FindApplicableTypeCommissionsProcessImpl extends AbstractProcessImpl<FindApplicableTypeCommissionsInput> implements FindApplicableTypeCommissionsProcess {

    private final TypeCommissionInfra typeCommissionInfra;
    private final ClientService clientService;

    public FindApplicableTypeCommissionsProcessImpl(TypeCommissionInfra typeCommissionInfra, ClientService clientService) {
        this.typeCommissionInfra = typeCommissionInfra;
        this.clientService = clientService;
    }

    @Override
    public void validate(FindApplicableTypeCommissionsInput findApplicableTypeCommissionsInput, Result result) {

        // Validation du ref de type compte
        if (findApplicableTypeCommissionsInput.getRefTypeCompte() == null || findApplicableTypeCommissionsInput.getRefTypeCompte() == "") {
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.NullRefTypeCompte"));
        }

        // Validation de la date d'opération
        if (findApplicableTypeCommissionsInput.getOperationDate() == null) {
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.NullOperationDate"));
        }

        // Validation du type d'opération
        if (findApplicableTypeCommissionsInput.getOperationType() == null || findApplicableTypeCommissionsInput.getOperationType() == "") {
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.NullOperationType"));
        }

        // Check if the Operation Type is either ACHAT or VENTE
        if (!findApplicableTypeCommissionsInput.getOperationType().equalsIgnoreCase("ACHAT") && !findApplicableTypeCommissionsInput.getOperationType().equalsIgnoreCase("VENTE")) {
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.InvalidOperationType"));
        }

        Result compteTypeResult = clientService.findCompteTypeByRef(findApplicableTypeCommissionsInput.getRefTypeCompte());

        //
        if (compteTypeResult.getOutput() == null){
            result.addErrorMessage(typeCommissionInfra.getMessage("TypeCommission.FindApplicableTypeCommissions.CompteTypeNotFound"));
        }

    }

    @Override
    public void run(FindApplicableTypeCommissionsInput findApplicableTypeCommissionsInput, Result result) {
        List<TypeCommission> typeCommissionList = typeCommissionInfra.findApplicableTypeCommissionEntities(findApplicableTypeCommissionsInput.getOperationDate(), findApplicableTypeCommissionsInput.getOperationType(), findApplicableTypeCommissionsInput.getRefTypeCompte());
        result.setOutput(typeCommissionList);
    }
}
