package com.trading.action.secteur.infra.facade;


import com.trading.action.entreprise.domain.pojo.Secteur;
import com.trading.action.entreprise.infra.core.AbstractInfra;
import com.trading.action.entreprise.infra.entity.SecteurEntity;

import java.util.List;

public interface SecteurInfra extends AbstractInfra {
    Secteur findByLibelle(String reference);

    int deleteByLibelle(String reference);

    void save(Secteur secteur);

    int update(SecteurEntity secteurEntity);

    List<SecteurEntity> findAll();

    int update(Secteur secteur);
}
