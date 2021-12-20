package com.example.commissionservice.infra.dao;

import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.infra.entity.CommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionDao extends JpaRepository<CommissionEntity, Long> {
    public CommissionEntity findByRefAction(String refAction);

    public CommissionEntity findByRef(String ref);
}
