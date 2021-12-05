package com.trading.action.bourse.infra.impl;

import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.infra.core.AbstractInfraImpl;
import com.trading.action.bourse.infra.dao.EntrepriseDao;
import com.trading.action.bourse.infra.entity.EntrepriseEntity;
import com.trading.action.bourse.infra.facade.EntrepriseInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntrepriseInfraImpl extends AbstractInfraImpl implements EntrepriseInfra {
    @Autowired
    EntrepriseDao entrepriseDao;

    @Override
    public Entreprise findByReference(String reference) {
        EntrepriseEntity actionEntity = entrepriseDao.findByReference(reference);
        Entreprise action= new Entreprise();
        if(actionEntity!=null){
            BeanUtils.copyProperties(actionEntity,action);
            return action;
        }
       return null;
    }

    @Override
    public int deleteByReference(String reference) {
        return entrepriseDao.deleteByReference(reference);
    }

    @Override
    public void save(Entreprise entreprise) {
        EntrepriseEntity entrepriseEntity = new EntrepriseEntity();
        BeanUtils.copyProperties(entreprise,entrepriseEntity);
        entrepriseDao.save(entrepriseEntity);
    };


    @Override
    public int update(EntrepriseEntity entrepriseEntity) {
        entrepriseDao.save(entrepriseEntity);
        return 1;
    }

    @Override
    public List<EntrepriseEntity> findAll() {
        return entrepriseDao.findAll();
    }

    @Override
    public int update(Entreprise entreprise) {
        EntrepriseEntity entrepriseEntity = entrepriseDao.findByReference(entreprise.getReference());
        if(entrepriseEntity!=null){
            entrepriseDao.save(entrepriseEntity);
            return 1;
        }
        return -1;
    }
}
