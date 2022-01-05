package com.example.commissionservice.domain.TypeCommission.create;

import com.example.commissionservice.domain.core.AbstractProcessImpl;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.facade.TypeCommissionInfra;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Type;

public class TypeCommissionCreateProcessImpl extends AbstractProcessImpl<TypeCommissionCreateInput> implements TypeCommissionCreateProcess {

    private final TypeCommissionInfra typeCommissionInfra;

    public TypeCommissionCreateProcessImpl(TypeCommissionInfra typeCommissionInfra) {
        this.typeCommissionInfra = typeCommissionInfra;
    }

    @Override
    public void validate(TypeCommissionCreateInput typeCommissionCreateInput, Result result) {
        TypeCommission typeCommission = typeCommissionInfra.findByRef(typeCommissionCreateInput.getRef());
        if (typeCommission != null) {
            result.addErrorMessage(typeCommissionInfra.getMessage("typeCommission.already_exists"));
        }

        if (typeCommissionCreateInput.getMinimal() == null){
            result.addErrorMessage(typeCommissionInfra.getMessage("typeCommission.minimal_is_null"));
        }
    }

    @Override
    public void run(TypeCommissionCreateInput typeCommissionCreateInput, Result result) {
        TypeCommission typeCommission = new TypeCommission();
        /* typeCommission.setTypeCompte(typeCommissionCreateInput.getCompteType());
        typeCommission.setOperationType(typeCommissionCreateInput.getOperationType());
        typeCommission.setApplicationDateMax(typeCommissionCreateInput.getApplicationDateMax());
        typeCommission.setApplicationDateMin(typeCommissionCreateInput.getApplicationDateMin());
        typeCommission.setMinimal(typeCommissionCreateInput.getMinimal());
        typeCommission.setTva(typeCommissionCreateInput.isTva());
        typeCommission.setPercentage(typeCommissionCreateInput.getPercentage());
         */
        BeanUtils.copyProperties(typeCommissionCreateInput, typeCommission);
        typeCommission.setTypeCompte(typeCommissionCreateInput.getCompteType());
        typeCommissionInfra.save(typeCommission);
        result.addInfoMessage(typeCommissionInfra.getMessage("type_commission.created"));
    }
}
