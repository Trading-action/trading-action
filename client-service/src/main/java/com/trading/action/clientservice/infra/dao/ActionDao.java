package com.trading.action.clientservice.infra.dao;

import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao extends JpaRepository<ActionEntity,Long> {
    ActionEntity findByRef(String ref);

    List<ActionEntity> findByActionnaireUsername(String username);

    int deleteByRef(String ref);
}
