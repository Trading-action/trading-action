package com.trading.clientservice.infra.facade;

import com.trading.clientservice.domain.pojo.CompteType;
import com.trading.clientservice.infra.core.AbstractInfra;
import com.trading.clientservice.infra.entity.CompteEntity;
import com.trading.clientservice.infra.entity.CompteTypeEntity;

import java.util.List;

public interface CompteTypeInfra extends AbstractInfra {

    CompteType findByRef(String ref);

    int deleteByRef(String ref);

    CompteEntity save(CompteTypeEntity compteTypeEntity);

    int save(CompteType compteType);

    int update(CompteTypeEntity compteTypeEntity);

    List<CompteTypeEntity> findAll();

    int update(CompteType compteType);
}
