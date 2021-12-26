package com.example.commissionservice.infra.dao;

import com.example.commissionservice.infra.entity.CommissionDetailEntity;
import com.example.commissionservice.infra.entity.CommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionDao extends JpaRepository<CommissionEntity, Long> {
    CommissionEntity findByRefAction(String refAction);

    CommissionEntity findByRef(String ref);
}
