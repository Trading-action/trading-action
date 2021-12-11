package com.trading.action.bourseservice.infra.dao;

import com.trading.action.bourseservice.infra.entity.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseDao extends JpaRepository<EntrepriseEntity, Long> {
    EntrepriseEntity findByReference(String reference);
    int deleteByReference(String reference);
}
