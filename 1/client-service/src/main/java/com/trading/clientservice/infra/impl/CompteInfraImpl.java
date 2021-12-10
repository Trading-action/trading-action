package com.trading.clientservice.infra.impl;

import com.trading.clientservice.domain.pojo.Compte;
import com.trading.clientservice.domain.pojo.CompteType;
import com.trading.clientservice.infra.core.AbstractInfraImpl;
import com.trading.clientservice.infra.dao.CompteDao;
import com.trading.clientservice.infra.entity.CompteEntity;
import com.trading.clientservice.infra.entity.CompteTypeEntity;
import com.trading.clientservice.infra.facade.CompteInfra;
import com.trading.clientservice.infra.facade.CompteTypeInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompteInfraImpl extends AbstractInfraImpl implements CompteInfra {

    private final  CompteDao compteDao;
    private  final CompteTypeInfra compteTypeInfra;

    @Override
    public Compte findByRef(String ref) {
        CompteEntity compteEntity = compteDao.findByRef(ref);
        Compte compte = new Compte();

        if (compteEntity != null) {
            BeanUtils.copyProperties(compteEntity, compte);
            return compte ;
        }
        return null;
    }

    @Override
    public CompteEntity findCompteEntityByRef(String ref) {
        return compteDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return 0;
    }

    @Override
    public CompteEntity save(CompteEntity compteEntity) {
        return compteDao.save(compteEntity);
    }

    @Override
    public int save(Compte compte) {
        CompteEntity compteEntity = new CompteEntity();
        BeanUtils.copyProperties(compte, compteEntity);
        if (findByRef(compteEntity.getRef()) != null) {
            return -1;
        }

        CompteType compteType =compteTypeInfra.findByRef(compte.getRefTypeCompte());

        if (compteType == null) {
            return -1;
        }

        CompteTypeEntity compteTypeEntity = new CompteTypeEntity();
        compteTypeEntity.setId(compteType.getId());
        compteEntity.setTypeCompte(compteTypeEntity);

        compteDao.save(compteEntity);
        return 1;
    }

    @Override
    public int update(CompteEntity compteEntity) {
        return 0;
    }

    @Override
    public List<CompteEntity> findAll() {
        return compteDao.findAll();
    }

    @Override
    public int update(Compte Compte) {
        return 0;
    }
}
