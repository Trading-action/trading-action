package com.example.commissionservice.infra.facade;

import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.infra.core.AbstractInfra;
import com.example.commissionservice.infra.entity.CommissionEntity;

import java.util.List;

public interface CommissionInfra extends AbstractInfra {

    int save(Commission commission);

    CommissionEntity findByRefAction(String refAction);

    int update(CommissionEntity commission);

    List<CommissionEntity> findAll();

    Commission findByRef(String ref);
}
