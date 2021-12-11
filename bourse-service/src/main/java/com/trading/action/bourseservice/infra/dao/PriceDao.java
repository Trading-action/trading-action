package com.trading.action.bourseservice.infra.dao;

import com.trading.action.bourseservice.infra.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceDao extends JpaRepository<PriceEntity, Long> {
    PriceEntity findByReference(String reference);
    List<PriceEntity> findFirstByEntreprise_Libelle(String libelle);
    int deleteByReference(String reference);
}
