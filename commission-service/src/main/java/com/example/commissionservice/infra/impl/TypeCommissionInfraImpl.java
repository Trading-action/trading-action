package com.example.commissionservice.infra.impl;

import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.converter.TypeCommissionConverter;
import com.example.commissionservice.infra.core.AbstractInfraImpl;
import com.example.commissionservice.infra.dao.TypeCommissionDoa;
import com.example.commissionservice.infra.entity.TypeCommissionEntity;
import com.example.commissionservice.infra.facade.TypeCommissionInfra;
import com.example.commissionservice.infra.utils.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@Slf4j
public class TypeCommissionInfraImpl extends AbstractInfraImpl implements TypeCommissionInfra {

    @Autowired
    private TypeCommissionDoa typeCommissionDoa;
    @Autowired
    private TypeCommissionConverter typeCommissionConverter;

    /**
     *
     * @param typeCommission
     * @return
     */
    @Override
    public int save(TypeCommission typeCommission) {
        TypeCommissionEntity typeCommissionEntity = typeCommissionConverter.convertFromPojos(typeCommission);
        /// Generate Type Commission Reference
        typeCommissionDoa.save(typeCommissionEntity);
        return 0;
    }

    /**
     *
     * @param ref
     * @return
     */
    @Override
    public TypeCommission findByRef(String ref) {
        TypeCommissionEntity typeCommissionEntity = typeCommissionDoa.findByRef(ref);
        if (typeCommissionEntity != null) {
            return typeCommissionConverter.convertFromEntity(typeCommissionEntity);
        }
        return null;
    }

    /**
     *
     * @param operationDate
     * @param operationType
     * @param refTypeCompte
     * @return
     */
    @Override
    public List<TypeCommission> findApplicableTypeCommissionEntities(Instant operationDate, String operationType, String refTypeCompte) {
        System.out.println("operationDate: " + operationDate + ", operationType: " + operationType + ", refTypeCompte: " + refTypeCompte);
        Converter<TypeCommission, TypeCommissionEntity> typeCommissionTypeCommissionEntityConverter = new TypeCommissionConverter();
        List<TypeCommissionEntity> typeCommissionEntities = typeCommissionDoa.findApplicableTypeCommissionEntities(operationDate, operationType, refTypeCompte);
        List<TypeCommission> typeCommissions = typeCommissionTypeCommissionEntityConverter.createFromEntities(typeCommissionEntities);
        return typeCommissions;
    }
}
