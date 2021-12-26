package com.example.commissionservice.infra.impl;

import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.infra.converter.CommissionConverter;
import com.example.commissionservice.infra.converter.CommissionDetailsConverter;
import com.example.commissionservice.infra.core.AbstractInfraImpl;
import com.example.commissionservice.infra.dao.CommissionDetailDao;
import com.example.commissionservice.infra.entity.CommissionDetailEntity;
import com.example.commissionservice.infra.facade.CommissionDetailInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionDetailInfraImpl extends AbstractInfraImpl implements CommissionDetailInfra {

    @Autowired
    private CommissionDetailDao commissionDetailDao;

    /**
     * @param ref
     * @return
     */
    @Override
    public CommissionDetail findByRef(String ref) {
        CommissionDetailsConverter commissionDetailsConverter = new CommissionDetailsConverter();
        CommissionDetailEntity commissionDetailEntity = commissionDetailDao.findByRef(ref);
        CommissionDetail commissionDetail = commissionDetailsConverter.convertFromEntity(commissionDetailEntity);
        return commissionDetail;
    }

    /**
     * @param commissionDetail
     * @return
     */
    @Override
    public CommissionDetail save(CommissionDetail commissionDetail) {
        CommissionDetailsConverter commissionDetailsConverter = new CommissionDetailsConverter();
        CommissionDetailEntity commissionDetailEntity = commissionDetailsConverter.convertFromPojos(commissionDetail);
        return commissionDetailsConverter.convertFromEntity(commissionDetailDao.save(commissionDetailEntity));
    }



    /*@Override
    public int update(CommissionDetail commissionDetail) {
        CommissionDetailsConverter commissionDetailsConverter = new CommissionDetailsConverter();
        CommissionDetailEntity commissionDetailEntity = commissionDetailsConverter.convertFromPojos(commissionDetail);
        commissionDetailDao.save(commissionDetailEntity);
        return 0;
    }

     */


}
