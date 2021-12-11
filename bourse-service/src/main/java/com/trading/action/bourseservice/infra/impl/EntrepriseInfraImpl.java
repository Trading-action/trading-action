package com.trading.action.bourseservice.infra.impl;

import com.trading.action.bourseservice.domain.pojo.Entreprise;
import com.trading.action.bourseservice.infra.core.AbstractInfraImpl;
import com.trading.action.bourseservice.infra.dao.EntrepriseDao;
import com.trading.action.bourseservice.infra.entity.EntrepriseEntity;
import com.trading.action.bourseservice.infra.facade.EntrepriseInfra;
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
        EntrepriseEntity entrepriseEntity = entrepriseDao.findByReference(reference);
        Entreprise entreprise= new Entreprise();
        if(entrepriseEntity!=null){
            BeanUtils.copyProperties(entrepriseEntity,entreprise);
            return entreprise;
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
