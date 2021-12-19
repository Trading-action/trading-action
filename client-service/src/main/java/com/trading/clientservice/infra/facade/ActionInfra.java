package com.trading.clientservice.infra.facade;

import com.trading.clientservice.domain.pojo.Action;
import com.trading.clientservice.infra.core.AbstractInfra;
import com.trading.clientservice.infra.entity.ActionEntity;

import java.util.List;

public interface ActionInfra extends AbstractInfra {

    Action findByRef(String ref);

    int deleteByRef(String ref);

    int save(ActionEntity actionEntity);
    void save(Action action);

    int update(ActionEntity actionEntity);

    List<ActionEntity> findAll();

    int update(Action action);

    List<Action> findByActionnaireUsername(String username);

    List<Action> findByRefEntrepriseAndActionnaireUsername(String refEnreprise, String username);

    List<String> findEntreprises(String username);


}
