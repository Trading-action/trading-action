package com.trading.action.clientservice.infra.dao;

import com.trading.action.clientservice.infra.entity.CompteEntity;
import com.trading.action.clientservice.infra.entity.CompteTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteTypeDao extends JpaRepository<CompteTypeEntity,Long> {
    CompteTypeEntity findByRef(String ref);
    int deleteByRef(String ref);
}
