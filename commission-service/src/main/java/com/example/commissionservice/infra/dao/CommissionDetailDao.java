package com.example.commissionservice.infra.dao;

import com.example.commissionservice.infra.entity.CommissionDetailEntity;
import com.example.commissionservice.infra.entity.CommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommissionDetailDao extends JpaRepository<CommissionDetailEntity, Long> {

    CommissionDetailEntity findByRef(String ref);

    List<CommissionDetailEntity> findCommissionDetailEntitiesByCommissionEntity(CommissionEntity commissionEntity);
}
