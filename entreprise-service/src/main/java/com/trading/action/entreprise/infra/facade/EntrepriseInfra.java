package com.trading.action.entreprise.infra.facade;

import com.trading.action.entreprise.domain.pojo.Entreprise;
import com.trading.action.entreprise.infra.core.AbstractInfra;
import com.trading.action.entreprise.infra.entity.EntrepriseEntity;

import java.util.List;

public interface EntrepriseInfra extends AbstractInfra {
    Entreprise findByLibelle(String reference);

    int deleteByLibelle(String reference);

    void save(Entreprise entreprise);

    void saveWithPrice(Entreprise entreprise);

    int update(EntrepriseEntity entrepriseEntity);

    List<EntrepriseEntity> findAll();

    int update(Entreprise entreprise);


}
