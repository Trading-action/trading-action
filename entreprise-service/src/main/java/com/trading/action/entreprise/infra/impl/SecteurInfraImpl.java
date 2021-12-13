package com.trading.action.entreprise.infra.impl;

import com.trading.action.entreprise.domain.pojo.Secteur;
import com.trading.action.entreprise.infra.core.AbstractInfraImpl;
import com.trading.action.entreprise.infra.dao.SecteurDao;
import com.trading.action.entreprise.infra.entity.SecteurEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.trading.action.secteur.infra.facade.SecteurInfra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurInfraImpl extends AbstractInfraImpl implements SecteurInfra {
    @Autowired
    SecteurDao secteurDao;
    
    @Override
    public Secteur findByLibelle(String libelle) {
        SecteurEntity secteurEntity = secteurDao.findFirstByLibelle(libelle);
        Secteur secteur= new Secteur();
        if(secteurEntity!=null){
            BeanUtils.copyProperties(secteurEntity,secteur);
            return secteur;
        }
        return null;
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return secteurDao.deleteByLibelle(libelle);
    }

    @Override
    public void save(Secteur secteur) {
        SecteurEntity secteurEntity = new SecteurEntity();
        BeanUtils.copyProperties(secteur,secteurEntity);
        secteurDao.save(secteurEntity);
    };

    @Override
    public int update(SecteurEntity secteurEntity) {
        secteurDao.save(secteurEntity);
        return 1;
    }

    @Override
    public List<SecteurEntity> findAll() {
        return secteurDao.findAll();
    }

    @Override
    public int update(Secteur secteur) {
        SecteurEntity secteurEntity = secteurDao.findFirstByLibelle(secteur.getLibelle());
        if(secteurEntity!=null){
            secteurDao.save(secteurEntity);
            return 1;
        }
        return -1;
    }
}
