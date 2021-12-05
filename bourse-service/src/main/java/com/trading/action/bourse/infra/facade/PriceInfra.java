package com.trading.action.bourse.infra.facade;

import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.domain.pojo.Price;
import com.trading.action.bourse.infra.core.AbstractInfra;
import com.trading.action.bourse.infra.entity.PriceEntity;

import java.util.List;

public interface PriceInfra extends AbstractInfra {
    public List<PriceEntity> findByEntreprise(String libelle);

    Entreprise findByReference(String reference);

    int deleteByReference(String reference);

    void save(Price price);

    int update(PriceEntity priceEntity);

    List<PriceEntity> findAll();

    void updatePojo(Price price);
}
