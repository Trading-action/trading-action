package com.trading.action.clientservice.infra.facade;

import com.trading.action.clientservice.domain.pojo.Actionnaire;
import com.trading.action.clientservice.infra.core.AbstractInfra;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;

import java.util.List;

public interface ActionnaireInfra extends AbstractInfra {

    Actionnaire findByRef(String ref);

    int deleteByRef(String ref);

    int save(Actionnaire actionnaire);

    int update(ActionnaireEntity actionnaireEntity);

    List<ActionnaireEntity> findAll();

    int update(Actionnaire actionnaire);
}
