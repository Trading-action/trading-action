package com.trading.action.bourse.infra.impl;

import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.domain.pojo.Price;
import com.trading.action.bourse.infra.core.AbstractInfraImpl;
import com.trading.action.bourse.infra.dao.PriceDao;
import com.trading.action.bourse.infra.entity.PriceEntity;
import com.trading.action.bourse.infra.facade.PriceInfra;
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
        BeanUtils.copyProperties(price,priceEntity);
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
