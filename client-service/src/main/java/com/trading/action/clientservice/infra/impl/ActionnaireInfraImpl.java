package com.trading.action.clientservice.infra.impl;

import com.trading.action.clientservice.domain.pojo.Actionnaire;
import com.trading.action.clientservice.infra.core.AbstractInfraImpl;
import com.trading.action.clientservice.infra.dao.ActionnaireDao;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionnaireInfraImpl  extends AbstractInfraImpl implements ActionnaireInfra {

    @Autowired
    private ActionnaireDao actionnaireDao;
    @Override
    public Actionnaire findByReference(String reference) {
        ActionnaireEntity actionnaireEntity = actionnaireDao.findByReference(reference);
        Actionnaire actionnaire= new Actionnaire();
        if(actionnaireEntity!=null){
            BeanUtils.copyProperties(actionnaireEntity,actionnaire);
        }
        return actionnaire;
    }

    @Override
    public int deleteByReference(String reference) {
        return actionnaireDao.deleteByReference(reference);
    }

    @Override
    public int save(ActionnaireEntity actionnaireEntity) {
        if (findByReference(actionnaireEntity.getRef()) != null) {
            return -1;
        }
        actionnaireDao.save(actionnaireEntity);
        return 1;
    }

    @Override
    public int update(ActionnaireEntity actionnaireEntity) {
        if (findByReference(actionnaireEntity.getRef()) == null)
            return -1;
        actionnaireDao.save(actionnaireEntity);
        return 1;
    }

    @Override
    public List<ActionnaireEntity> findAll() {
        return actionnaireDao.findAll();
    }

    @Override
    public int update(Actionnaire actionnaire) {
        ActionnaireEntity actionnaireEntity = new ActionnaireEntity();
        BeanUtils.copyProperties(actionnaire,actionnaireEntity);
        return update(actionnaireEntity);
    }
}
