package com.trading.action.clientservice.infra.facade;

import com.trading.action.clientservice.domain.pojo.Action;
import com.trading.action.clientservice.domain.pojo.Actionnaire;
import com.trading.action.clientservice.infra.core.AbstractInfra;
import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;

import java.util.List;

public interface ActionInfra extends AbstractInfra {

    Action findByRef(String ref);

    int deleteByRef(String ref);

    int save(ActionEntity actionEntity);

    int update(ActionEntity actionEntity);

    List<ActionEntity> findAll();

    int update(Action action);

    List<Action> findByActionnaireUsername(String username);

}
