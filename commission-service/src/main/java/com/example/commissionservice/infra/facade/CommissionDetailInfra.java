package com.example.commissionservice.infra.facade;

import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.infra.core.AbstractInfra;
import com.example.commissionservice.infra.entity.CommissionDetailEntity;

import java.util.List;

public interface CommissionDetailInfra extends AbstractInfra {

    CommissionDetail findByRef(String ref);

    CommissionDetail save(CommissionDetail commissionDetail);

    List<CommissionDetail> findByOperationType(String operationType);
}
