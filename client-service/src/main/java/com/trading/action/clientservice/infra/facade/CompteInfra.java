package com.trading.action.clientservice.infra.facade;

import com.trading.action.clientservice.domain.pojo.Action;
import com.trading.action.clientservice.domain.pojo.Compte;
import com.trading.action.clientservice.infra.core.AbstractInfra;
import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.CompteEntity;

import java.util.List;

public interface CompteInfra extends AbstractInfra {

    Compte findByReference(String reference);

    int deleteByReference(String reference);

    int save(CompteEntity compteEntity);

    int update(CompteEntity compteEntity);

    List<CompteEntity> findAll();

    int update(Compte Compte);
}
