package com.trading.action.clientservice.infra.impl;

import com.trading.action.clientservice.application.dto.CompteTypeDto;
import com.trading.action.clientservice.domain.pojo.Compte;
import com.trading.action.clientservice.domain.pojo.CompteType;
import com.trading.action.clientservice.infra.core.AbstractInfraImpl;
import com.trading.action.clientservice.infra.dao.CompteDao;
import com.trading.action.clientservice.infra.dao.CompteTypeDao;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;
import com.trading.action.clientservice.infra.entity.CompteEntity;
import com.trading.action.clientservice.infra.entity.CompteTypeEntity;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;
import com.trading.action.clientservice.infra.facade.CompteInfra;
import com.trading.action.clientservice.infra.facade.CompteTypeInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompteTypeInfraImpl extends AbstractInfraImpl implements CompteTypeInfra {

    private final CompteTypeDao compteTypeDao;

    @Override
    public CompteType findByRef(String ref) {
        CompteTypeEntity compteTypeEntity = compteTypeDao.findByRef(ref);
        CompteType compteType = new CompteType();

        if (compteTypeEntity != null) {
            BeanUtils.copyProperties(compteTypeEntity, compteType);
            return compteType;
        }
        return null;
    }

    @Override
    public int deleteByRef(String ref) {
        return 0;
    }

    @Override
    public CompteEntity save(CompteTypeEntity compteTypeEntity) {
        return null;
    }

    @Override
    public int save(CompteType compteType) {

        CompteTypeEntity compteTypeEntity = new CompteTypeEntity();
        BeanUtils.copyProperties(compteType, compteTypeEntity);
        compteTypeDao.save(compteTypeEntity);

        return 1;
    }

    @Override
    public int update(CompteTypeEntity compteTypeEntity) {
        return 0;
    }

    @Override
    public List<CompteTypeEntity> findAll() {
        return compteTypeDao.findAll();
    }

    @Override
    public int update(CompteType compteType) {
        return 0;
    }
}
