package com.trading.action.clientservice.infra.impl;

import com.trading.action.clientservice.domain.pojo.Action;
import com.trading.action.clientservice.domain.pojo.Compte;
import com.trading.action.clientservice.infra.core.AbstractInfraImpl;
import com.trading.action.clientservice.infra.dao.ActionDao;
import com.trading.action.clientservice.infra.dao.CompteDao;
import com.trading.action.clientservice.infra.entity.ActionEntity;
import com.trading.action.clientservice.infra.entity.CompteEntity;
import com.trading.action.clientservice.infra.facade.ActionInfra;
import com.trading.action.clientservice.infra.facade.CompteInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompteInfraImpl extends AbstractInfraImpl implements CompteInfra {

    @Autowired
    private CompteDao compteDao;
    @Override
    public Compte findByReference(String reference) {
       return  null;
    }

    @Override
    public int deleteByReference(String reference) {
        return compteDao.deleteByReference(reference);
    }

    @Override
    public int save(CompteEntity compteEntity) {
        return 0;
    }

    @Override
    public int update(CompteEntity compteEntity) {
        return 0;
    }

    @Override
    public List<CompteEntity> findAll() {
        return null;
    }

    @Override
    public int update(Compte Compte) {
        return 0;
    }

}
