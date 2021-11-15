package com.trading.action.clientservice.infra.dao;

import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.CompteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteDao extends JpaRepository<CompteEntity,Long> {
    CompteEntity findByRef(String ref);
    int deleteByRef(String ref);
}
