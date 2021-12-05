package com.trading.action.bourse.infra.facade;

import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.infra.core.AbstractInfra;
import com.trading.action.bourse.infra.entity.PriceEntity;

import java.util.List;

public interface PriceInfra extends AbstractInfra {
    public List<PriceEntity> findByEntreprise(String libelle);

    Entreprise findByReference(String reference);

    int deleteByReference(String reference);

    int save(Entreprise entreprise);

    int update(PriceEntity priceEntity);

    List<PriceEntity> findAll();

    int update(Entreprise entreprise);
}
