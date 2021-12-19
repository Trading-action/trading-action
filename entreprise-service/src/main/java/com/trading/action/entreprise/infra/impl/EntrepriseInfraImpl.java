package com.trading.action.entreprise.infra.impl;

import com.trading.action.entreprise.domain.pojo.Entreprise;
import com.trading.action.entreprise.domain.pojo.Price;
import com.trading.action.entreprise.infra.core.AbstractInfraImpl;
import com.trading.action.entreprise.infra.dao.EntrepriseDao;
import com.trading.action.entreprise.infra.entity.EntrepriseEntity;
import com.trading.action.entreprise.infra.entity.PriceEntity;
import com.trading.action.entreprise.infra.entity.SecteurEntity;
import com.trading.action.entreprise.infra.facade.EntrepriseInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class EntrepriseInfraImpl extends AbstractInfraImpl implements EntrepriseInfra {
    @Autowired
    EntrepriseDao entrepriseDao;

    @Override
    public Entreprise findByLibelle(String libelle) {
        EntrepriseEntity entrepriseEntity = entrepriseDao.findByLibelle(libelle);
        Price price = new Price();
        Entreprise entreprise= new Entreprise();
        if(entrepriseEntity!=null){
            BeanUtils.copyProperties(entrepriseEntity,entreprise);
            if(entrepriseEntity.getPrixActuel()!= null){
                BeanUtils.copyProperties(entrepriseEntity.getPrixActuel(), price);
                entreprise.setPrixAction(price);
            }
            return entreprise;
        }
        return null;
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return entrepriseDao.deleteByLibelle(libelle);
    }

    @Override
    public void save(Entreprise entreprise) {
        EntrepriseEntity entrepriseEntity = new EntrepriseEntity();
        SecteurEntity secteurEntity = new SecteurEntity();
        BeanUtils.copyProperties(entreprise,entrepriseEntity);
        BeanUtils.copyProperties(entreprise.getSecteur(),secteurEntity);
        entrepriseEntity.setSecteur(secteurEntity);
        entrepriseDao.save(entrepriseEntity);
    };

    @Override
    public void saveWithPrice(Entreprise entreprise){
        EntrepriseEntity entrepriseEntity = new EntrepriseEntity();
        PriceEntity priceEntity = new PriceEntity();
        BeanUtils.copyProperties(entreprise.getPrixAction(), priceEntity);
        BeanUtils.copyProperties(entreprise,entrepriseEntity);
        entrepriseEntity.setPrixActuel(priceEntity);
        entrepriseDao.save(entrepriseEntity);
    }


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
        EntrepriseEntity entrepriseEntity = entrepriseDao.findByLibelle(entreprise.getLibelle());
        if(entrepriseEntity!=null){
            entrepriseDao.save(entrepriseEntity);
            return 1;
        }
        return -1;
    }
}
