package com.trading.action.clientservice.infra.impl;

import com.trading.action.clientservice.domain.pojo.Action;
import com.trading.action.clientservice.domain.pojo.Actionnaire;
import com.trading.action.clientservice.infra.core.AbstractInfraImpl;
import com.trading.action.clientservice.infra.dao.ActionDao;
import com.trading.action.clientservice.infra.dao.ActionnaireDao;
import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;
import com.trading.action.clientservice.infra.facade.ActionInfra;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntrepriseInfraImpl extends AbstractInfraImpl implements ActionInfra {

    @Autowired
    private ActionDao actionDao;
    @Override
    public Action findByReference(String reference) {
        ActionEntity actionEntity = actionDao.findByReference(reference);
        Action action= new Action();
        if(actionEntity!=null){
            BeanUtils.copyProperties(actionEntity,action);
        }
        return action;
    }

    @Override
    public int deleteByReference(String reference) {
        return actionDao.deleteByReference(reference);
    }

    @Override
    public int save(ActionEntity actionEntity) {
        if (findByReference(actionEntity.getRef()) != null) {
            return -1;
        }
        actionDao.save(actionEntity);
        return 1;
    }

    @Override
    public int update(ActionEntity actionEntity) {
        if (findByReference(actionEntity.getRef()) == null)
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
        BeanUtils.copyProperties(action,actionEntity);
        return update(actionEntity);
    }
}
