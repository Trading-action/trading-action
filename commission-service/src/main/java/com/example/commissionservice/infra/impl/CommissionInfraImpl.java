package com.example.commissionservice.infra.impl;

import com.example.commissionservice.domain.pojo.*;
import com.example.commissionservice.infra.converter.CommissionConverter;
import com.example.commissionservice.infra.converter.CommissionDetailsConverter;
import com.example.commissionservice.infra.core.AbstractInfraImpl;
import com.example.commissionservice.infra.dao.CommissionDao;
import com.example.commissionservice.infra.entity.CommissionEntity;
import com.example.commissionservice.infra.facade.CommissionDetailInfra;
import com.example.commissionservice.infra.facade.CommissionInfra;
import com.example.commissionservice.infra.facade.TypeCommissionInfra;
import com.example.commissionservice.infra.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CommissionInfraImpl extends AbstractInfraImpl implements CommissionInfra {

    @Autowired
    private CommissionDao commissionDao;
    @Autowired
    private TypeCommissionInfra typeCommissionInfra;

    @Autowired
    private CommissionDetailInfra commissionDetailInfra;

    @Autowired
    private CommissionConverter commissionConverter;

    /**
     * @param commission
     * @return
     */
    @Override
    public int save(Commission commission) {
        CommissionEntity commissionEntity = commissionConverter.convertFromPojos(commission);
        commissionDao.save(commissionEntity);
        return 0;
    }

    /**
     * @param refAction
     * @return
     */
    @Override
    public CommissionEntity findByRefAction(String refAction) {
        return commissionDao.findByRefAction(refAction);
    }

    /**
     * @param commission
     * @return
     */
    @Override
    public int update(Commission commission) {
        CommissionEntity commissionEntity = commissionConverter.convertFromPojos(commission);
        commissionDao.save(commissionEntity);
        return 0;
    }

    @Override
    public List<Commission> findAll() {
        Converter<Commission, CommissionEntity> commissionCommissionEntityConvert = new CommissionConverter();
        List<CommissionEntity> commissionEntities = commissionDao.findAll();
        List<Commission> commissions = commissionCommissionEntityConvert.createFromEntities(commissionEntities);
        return commissions;
    }

    /**
     * @param ref
     * @return
     */
    @Override
    public Commission findByRef(String ref) {
        CommissionEntity commissionEntity = commissionDao.findByRef(ref);
        if (commissionEntity != null) {
            return commissionConverter.convertFromEntity(commissionEntity);
        }
        return null;
    }

    /**
     * @param action
     * @param compte
     * @param operationType
     * @return
     */
    @Override
    public BigDecimal calculateCommission(Action action, Compte compte, String operationType) {
        Instant operationDate = Instant.now();

        BigDecimal actionPrice = action.getPrix();

        // Find All Aplicable Commission Types
        List<CommissionDetail> commissionDetails = new ArrayList<>();
        List<TypeCommission> typeCommissions = typeCommissionInfra.findApplicableTypeCommissionEntities(operationDate, operationType, compte.getRefTypeCompte());
        BigDecimal totalCommissionPrice = typeCommissions.stream().map(typeCommission -> {
                    BigDecimal percentage = BigDecimal.valueOf(typeCommission.getPercentage()).multiply(BigDecimal.valueOf(0.01));
                    BigDecimal commissionPrice = BigDecimal.ZERO;
                    boolean tva = typeCommission.isTva();
                    BigDecimal minimal = typeCommission.getMinimal();

                    commissionPrice = commissionPrice.add(percentage.multiply(actionPrice));

                    // If the commissionPrice is less than the minimal price => commissionPrice = minimal
                    if (commissionPrice.compareTo(minimal) == -1) {
                        commissionPrice = minimal;
                    }

                    // We suppose tha the tva is 20% for all the commissions
                    if (tva) {
                        commissionPrice = commissionPrice.add(commissionPrice.multiply(BigDecimal.valueOf(0.2)));
                    }

                    CommissionDetail commissionDetail = new CommissionDetail("commissionDetail" + new Date().getTime(), commissionPrice, typeCommission);
                    /**
                     * Save Commission DETAILS
                     */
                    //commissionDetail.setRef("commissionDetail" + date.getTime());
                    CommissionDetail savedCommissionDetail = commissionDetailInfra.save(commissionDetail);
                    if (savedCommissionDetail != null) {
                        commissionDetails.add(savedCommissionDetail);
                    }
                    return commissionPrice;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        /**
         * Save Commission
         */
        Commission commission = new Commission();
        commission.setDateCommission(operationDate);
        commission.setAction(action);
        commission.setTotalPrice(totalCommissionPrice);
        commission.setCommissionDetails(commissionDetails);
        commission.setRef("commission" + operationDate.getNano());
        save(commission);
        return totalCommissionPrice;
    }
}
