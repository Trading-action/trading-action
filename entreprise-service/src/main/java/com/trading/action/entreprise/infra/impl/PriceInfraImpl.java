package com.trading.action.entreprise.infra.impl;

import com.trading.action.entreprise.domain.pojo.Entreprise;
import com.trading.action.entreprise.domain.pojo.Price;
import com.trading.action.entreprise.infra.core.AbstractInfraImpl;
import com.trading.action.entreprise.infra.dao.PriceDao;
import com.trading.action.entreprise.infra.entity.EntrepriseEntity;
import com.trading.action.entreprise.infra.entity.PriceEntity;
import com.trading.action.entreprise.infra.facade.PriceInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
    public Price findByReference(String reference) {
        PriceEntity priceEntity = priceDao.findByReference(reference);
        Price price= new Price();
        if(priceEntity!=null){
            BeanUtils.copyProperties(priceEntity,price);
        }
        return price;
    }

    @Override
    public int deleteByReference(String reference) {
        return priceDao.deleteByReference(reference);
    }

    @Override
    public boolean hasOlderPrices(String libelle, Instant createdAt){
        return priceDao.hasOlderPrices(libelle,createdAt);
    }

    @Override
    public Price save(Price price) {
        PriceEntity priceEntity= new PriceEntity();
        EntrepriseEntity entrepriseEntity = new EntrepriseEntity();
        Entreprise entreprise = new Entreprise();

        BeanUtils.copyProperties(price,priceEntity);
        BeanUtils.copyProperties(price.getEntreprise(),entrepriseEntity);
        priceEntity.setEntreprise(entrepriseEntity);

        priceEntity = priceDao.save(priceEntity);

        BeanUtils.copyProperties(priceEntity, price);
        BeanUtils.copyProperties(priceEntity.getEntreprise(), entreprise);
        price.setEntreprise(entreprise);
        return price;
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

    @Override
    public List<PriceEntity> findPrixHistoryByDateAndEntreprise(Instant date, String libelleEntreprise) {
        List<PriceEntity> pricesLess = priceDao.findHistory(libelleEntreprise,date);
        return pricesLess;
    }
}
