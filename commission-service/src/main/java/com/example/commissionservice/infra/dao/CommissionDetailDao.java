package com.example.commissionservice.infra.dao;

import com.example.commissionservice.infra.entity.CommissionDetailEntity;
import com.example.commissionservice.infra.entity.CommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommissionDetailDao extends JpaRepository<CommissionDetailEntity, Long> {

    CommissionDetailEntity findByRef(String ref);

    List<CommissionDetailEntity> findCommissionDetailEntitiesByCommissionEntity(CommissionEntity commissionEntity);

    @Query(value = "SELECT cd FROM CommissionDetailEntity cd WHERE cd.typeCommissionEntity.operationType = :operationType")
    List<CommissionDetailEntity> findByOperationType(@Param("operationType") String operationType);
}
