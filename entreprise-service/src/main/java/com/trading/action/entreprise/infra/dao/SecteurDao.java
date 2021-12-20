package com.trading.action.entreprise.infra.dao;

import com.trading.action.entreprise.infra.entity.EntrepriseEntity;
import com.trading.action.entreprise.infra.entity.SecteurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurDao extends JpaRepository<SecteurEntity, Long> {
    SecteurEntity findFirstByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
