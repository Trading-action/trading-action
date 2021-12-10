package com.trading.clientservice.infra.impl;

import com.trading.clientservice.domain.pojo.Action;
import com.trading.clientservice.infra.core.AbstractInfraImpl;
import com.trading.clientservice.infra.dao.ActionDao;
import com.trading.clientservice.infra.entity.ActionEntity;
import com.trading.clientservice.infra.facade.ActionInfra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ActionInfraImpl extends AbstractInfraImpl implements ActionInfra {

    @Autowired
    private ActionDao actionDao;

    @Override
    public Action findByRef(String ref) {
        ActionEntity actionEntity = actionDao.findByRef(ref);
        Action action = new Action();
        if (actionEntity != null) {
            BeanUtils.copyProperties(actionEntity, action);
        }
        return action;
    }

    @Override
    public int deleteByRef(String ref) {
        return actionDao.deleteByRef(ref);
    }

    @Override
    public int save(ActionEntity actionEntity) {
        if (findByRef(actionEntity.getRef()) != null) {
            return -1;
        }
        actionDao.save(actionEntity);
        return 1;
    }

    @Override
    public int update(ActionEntity actionEntity) {
        if (findByRef(actionEntity.getRef()) == null)
            return -1;
        actionDao.save(actionEntity);
        return 1;
    }

    @Override
    public List<ActionEntity> findAll() {
        return actionDao.findAll();
    }

    @Override
    public int update(Action action) {
        ActionEntity actionEntity = new ActionEntity();
        BeanUtils.copyProperties(action, actionEntity);
        return update(actionEntity);
    }

    @Override
    public List<Action> findByActionnaireUsername(String username) {

        List<ActionEntity> actionEntities = actionDao.findByActionnaireUsername(username);
        log.error("findByActionnaireUsername {}", actionEntities);
        List<Action> actions = new ArrayList<>();

        actions = actionEntities.stream().map((actionEntity -> {
            Action action = new Action();
            BeanUtils.copyProperties(actionEntity, action);
            return action;
        })).collect(Collectors.toList());

        return actions;
    }

    @Override
    public List<Action> findByRefEntrepriseAndActionnaireUsername(String refEnreprise, String username) {
        List<ActionEntity>  actionEntities = actionDao.findByRefEntrepriseAndActionnaireUsername(refEnreprise,username);
        List<Action> actions = new ArrayList<>();

        actions = actionEntities.stream().map((actionEntity -> {
            Action action = new Action();
            BeanUtils.copyProperties(actionEntity, action);
            return action;
        })).collect(Collectors.toList());

        return actions;
    }


    @Override
    public List<String> findEntreprises(String username) {
        return actionDao.findEntreprises(username);
    }
}
