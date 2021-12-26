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

    List<Action> findByUsernameActionnaire(String username);

    List<Action> findByReferenceEntrepriseAndAndUsernameActionnaire(String referecneEnreprise, String username);

    List<String> findEntreprisesByUsernameActionnaire(String username);


}
