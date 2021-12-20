package com.trading.action.bourseservice.infra.facade;

import com.trading.action.bourseservice.domain.pojo.Action;
import com.trading.action.bourseservice.infra.core.AbstractInfra;
import com.trading.action.bourseservice.infra.entity.ActionEntity;

import java.util.List;

public interface ActionInfra extends AbstractInfra {

    Action findByReference(String ref);

    int deleteByReference(String ref);

    int save(ActionEntity actionEntity);
    void save(Action action);

    int update(ActionEntity actionEntity);

    List<ActionEntity> findAll();

    int update(Action action);

    List<Action> findByActionnaireUsername(String username);

    List<Action> findByRefEntrepriseAndActionnaireUsername(String refEnreprise, String username);

    List<String> findEntreprises(String username);


}
