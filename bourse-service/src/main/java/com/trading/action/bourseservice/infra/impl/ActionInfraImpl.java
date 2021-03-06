package com.trading.action.bourseservice.infra.impl;

import com.trading.action.bourseservice.domain.pojo.Action;
import com.trading.action.bourseservice.infra.core.AbstractInfraImpl;
import com.trading.action.bourseservice.infra.dao.ActionDao;
import com.trading.action.bourseservice.infra.entity.ActionEntity;
import com.trading.action.bourseservice.infra.facade.ActionInfra;
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
    public Action findByReference(String ref) {
        ActionEntity actionEntity = actionDao.findByReference(ref);
        Action action = new Action();
        if (actionEntity != null) {
            BeanUtils.copyProperties(actionEntity, action);
            return action;
        }
        return null;
    }

    @Override
    public int deleteByReference(String ref) {
        return actionDao.deleteByReference(ref);
    }

    @Override
    public int save(ActionEntity actionEntity) {
        if (findByReference(actionEntity.getReference()) != null) {
            return -1;
        }
        actionDao.save(actionEntity);
        return 1;
    }

    @Override
    public void save(Action action) {
        ActionEntity actionEntity = new ActionEntity();
        BeanUtils.copyProperties(action, actionEntity);
        actionDao.save(actionEntity);
    }

    @Override
    public int update(ActionEntity actionEntity) {
        if (findByReference(actionEntity.getReference()) == null)
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
    public List<Action> findByUsernameActionnaire(String username) {
        List<ActionEntity> actionEntities = actionDao.findByUsernameActionnaire(username);
        log.error("findByActionnaireUsername {}", actionEntities);
       return actionEntities.stream().map((actionEntity -> {
            Action action = new Action();
            BeanUtils.copyProperties(actionEntity, action);
            return action;
        })).collect(Collectors.toList());
    }

    @Override
    public List<Action> findByReferenceEntrepriseAndAndUsernameActionnaire(String referecneEnreprise, String username) {
        List<ActionEntity>  actionEntities = actionDao.findByReferenceEntrepriseAndAndUsernameActionnaire(referecneEnreprise,username);
        return actionEntities.stream().map((actionEntity -> {
            Action action = new Action();
            BeanUtils.copyProperties(actionEntity, action);
            return action;
        })).collect(Collectors.toList());
    }

    @Override
    public List<String> findEntreprisesByUsernameActionnaire(String username) {
        return actionDao.findEntreprisesByUsernameActionnaire(username);
    }


}
