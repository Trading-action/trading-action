package com.example.commissionservice.infra.facade;

import com.example.commissionservice.domain.pojo.Action;
import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.domain.pojo.Compte;
import com.example.commissionservice.infra.core.AbstractInfra;
import com.example.commissionservice.infra.entity.CommissionEntity;

import java.math.BigDecimal;
import java.util.List;

public interface CommissionInfra extends AbstractInfra {

    int save(Commission commission);

    CommissionEntity findByRefAction(String refAction);

    int update(Commission commission);

    List<Commission> findAll();

    Commission findByRef(String ref);

    BigDecimal calculateCommission(Action action, Compte compte, String operationType);
}
