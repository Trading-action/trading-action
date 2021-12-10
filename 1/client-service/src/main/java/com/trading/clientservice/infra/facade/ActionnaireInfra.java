package com.trading.clientservice.infra.facade;

import com.trading.clientservice.domain.pojo.Action;
import com.trading.clientservice.domain.pojo.Actionnaire;
import com.trading.clientservice.domain.pojo.Portefeuille;
import com.trading.clientservice.infra.core.AbstractInfra;
import com.trading.clientservice.infra.entity.ActionnaireEntity;

import java.util.List;

public interface ActionnaireInfra extends AbstractInfra {

    Actionnaire findByRef(String ref);
    Actionnaire findByUsername(String username);

    Portefeuille getPortefeuilles(List<Action> actions);

    int deleteByRef(String ref);

    int save(Actionnaire actionnaire);

    int update(ActionnaireEntity actionnaireEntity);

    List<ActionnaireEntity> findAll();

    int update(Actionnaire actionnaire);
}
