package com.trading.action.clientservice.infra.dao;

import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionnaireDao extends JpaRepository<ActionnaireEntity,Long> {
    ActionnaireEntity findByRef(String ref);
    ActionnaireEntity findByUsername(String username);
    int deleteByRef(String ref);
}
