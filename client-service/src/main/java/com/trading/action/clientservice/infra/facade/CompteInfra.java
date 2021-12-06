package com.trading.action.clientservice.infra.facade;

import com.trading.action.clientservice.domain.pojo.Action;
import com.trading.action.clientservice.domain.pojo.Actionnaire;
import com.trading.action.clientservice.domain.pojo.Compte;
import com.trading.action.clientservice.infra.core.AbstractInfra;
import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.CompteEntity;

import java.util.List;

public interface CompteInfra extends AbstractInfra {

    Compte findByRef(String ref);

    CompteEntity findCompteEntityByRef(String ref);

    int deleteByRef(String ref);

    CompteEntity save(CompteEntity compteEntity);
    int save(Compte compte);

    int update(CompteEntity compteEntity);

    List<CompteEntity> findAll();

    int update(Compte Compte);
}
