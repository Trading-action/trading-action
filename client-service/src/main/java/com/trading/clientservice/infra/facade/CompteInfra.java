package com.trading.clientservice.infra.facade;

import com.trading.clientservice.domain.pojo.Compte;
import com.trading.clientservice.infra.core.AbstractInfra;
import com.trading.clientservice.infra.entity.CompteEntity;

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
