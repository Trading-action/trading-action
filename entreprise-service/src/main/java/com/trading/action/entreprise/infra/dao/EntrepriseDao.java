package com.trading.action.entreprise.infra.dao;

import com.trading.action.entreprise.infra.entity.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseDao extends JpaRepository<EntrepriseEntity, Long> {
    EntrepriseEntity findByLibelle(String reference);
    int deleteByLibelle(String reference);
}
