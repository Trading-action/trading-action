package com.trading.action.bourse.infra.facade;

import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.infra.core.AbstractInfra;
import com.trading.action.bourse.infra.entity.EntrepriseEntity;

import java.util.List;

public interface EntrepriseInfra extends AbstractInfra {
    Entreprise findByReference(String reference);

    int deleteByReference(String reference);

    void save(Entreprise entreprise);

    int update(EntrepriseEntity entrepriseEntity);

    List<EntrepriseEntity> findAll();

    int update(Entreprise entreprise);
}
