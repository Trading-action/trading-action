package com.trading.clientservice.infra.dao;

import com.trading.clientservice.infra.entity.ActionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionnaireDao extends JpaRepository<ActionnaireEntity,Long> {
    ActionnaireEntity findByRef(String ref);
    ActionnaireEntity findByUsername(String username);
    int deleteByRef(String ref);
}
