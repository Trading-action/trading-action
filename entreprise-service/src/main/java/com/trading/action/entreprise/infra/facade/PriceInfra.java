package com.trading.action.entreprise.infra.facade;

import com.trading.action.entreprise.domain.pojo.Price;
import com.trading.action.entreprise.infra.core.AbstractInfra;
import com.trading.action.entreprise.infra.entity.PriceEntity;

import java.time.Instant;
import java.util.List;

public interface PriceInfra extends AbstractInfra {
    public List<PriceEntity> findByEntreprise(String libelle);

    Price findByReference(String reference);

    int deleteByReference(String reference);

    Price save(Price price);

    int update(PriceEntity priceEntity);

    List<PriceEntity> findAll();

    void updatePojo(Price price);

    boolean hasOlderPrices(String libelle, Instant createdAt);

    List<PriceEntity> findPrixHistoryByDateAndEntreprise(Instant date, String libelleEntreprise);
}
