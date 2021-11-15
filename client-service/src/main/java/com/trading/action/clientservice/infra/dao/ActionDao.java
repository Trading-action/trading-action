package com.trading.action.clientservice.infra.dao;

import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionDao extends JpaRepository<ActionEntity,Long> {
    ActionEntity findByRef(String ref);
    int deleteByRef(String ref);
}
