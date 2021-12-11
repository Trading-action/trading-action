package com.trading.action.bourseservice.infra.impl;

import com.trading.action.bourseservice.domain.pojo.Entreprise;
import com.trading.action.bourseservice.domain.pojo.Price;
import com.trading.action.bourseservice.infra.core.AbstractInfraImpl;
import com.trading.action.bourseservice.infra.dao.PriceDao;
import com.trading.action.bourseservice.infra.entity.EntrepriseEntity;
import com.trading.action.bourseservice.infra.entity.PriceEntity;
import com.trading.action.bourseservice.infra.facade.PriceInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceInfraImpl extends AbstractInfraImpl implements PriceInfra {
    @Autowired
    PriceDao priceDao;
    @Override
    public List<PriceEntity> findByEntreprise(String libelle) {
        return priceDao.findFirstByEntreprise_Libelle(libelle);
    }
    @Override
    public Entreprise findByReference(String reference) {
        PriceEntity actionEntity = priceDao.findByReference(reference);
        Entreprise action= new Entreprise();
        if(actionEntity!=null){
            BeanUtils.copyProperties(actionEntity,action);
        }
        return action;
    }

    @Override
    public int deleteByReference(String reference) {
        return priceDao.deleteByReference(reference);
    }

    @Override
    public void save(Price price) {
        PriceEntity priceEntity= new PriceEntity();
        EntrepriseEntity entrepriseEntity = new EntrepriseEntity();
        BeanUtils.copyProperties(price,priceEntity);
        BeanUtils.copyProperties(price.getEntreprise(),entrepriseEntity);
        priceEntity.setEntreprise(entrepriseEntity);
        priceDao.save(priceEntity);
    };


    @Override
    public int update(PriceEntity priceEntity) {
        priceDao.save(priceEntity);
        return 1;
    }

    @Override
    public List<PriceEntity> findAll() {
        return priceDao.findAll();
    }

    @Override
    public void updatePojo(Price price) {
        PriceEntity priceEntity = new PriceEntity();
        BeanUtils.copyProperties(price,priceEntity);
        priceDao.save(priceEntity);
    }
}
