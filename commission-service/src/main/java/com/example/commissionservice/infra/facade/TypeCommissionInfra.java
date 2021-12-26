package com.example.commissionservice.infra.facade;

import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.core.AbstractInfra;

import java.time.Instant;
import java.util.List;

public interface TypeCommissionInfra extends AbstractInfra {

    int save(TypeCommission typeCommission);

    TypeCommission findByRef(String ref);

    List<TypeCommission> findApplicableTypeCommissionEntities(Instant operationDate, String operationType, String refTypeCompte);
}
