package com.example.commissionservice.infra.impl;

import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.infra.core.AbstractInfraImpl;
import com.example.commissionservice.infra.dao.CommissionDao;
import com.example.commissionservice.infra.entity.CommissionEntity;
import com.example.commissionservice.infra.facade.CommissionInfra;
import com.trading.clientservice.domain.pojo.Actionnaire;
import com.trading.clientservice.infra.entity.ActionnaireEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class CommissionInfraImpl extends AbstractInfraImpl implements CommissionInfra {

    @Autowired
    private CommissionDao commissionDao;

    @Override
    public int save(Commission commission) {
        CommissionEntity commissionEntity = new CommissionEntity();
        BeanUtils.copyProperties(commission, commissionEntity);
        commissionEntity.setRefAction(commission.getAction().getRef());
        commissionDao.save(commissionEntity);
        return 0;
    }

    @Override
    public CommissionEntity findByRefAction(String refAction) {
        return commissionDao.findByRefAction(refAction);
    }

    @Override
    public int update(CommissionEntity commission) {
        commissionDao.save(commission);
        return 0;
    }

    @Override
    public List<CommissionEntity> findAll() {
        return commissionDao.findAll();
    }

    @Override
    public Commission findByRef(String ref) {
        CommissionEntity commissionEntity = commissionDao.findByRef(ref);
        Commission commission = new Commission();
        if (commissionEntity != null) {
            BeanUtils.copyProperties(commissionEntity, commission);
            return commission;
        }
        return null;
    }
}
