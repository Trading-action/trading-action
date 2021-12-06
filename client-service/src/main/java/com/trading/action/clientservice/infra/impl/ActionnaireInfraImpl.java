package com.trading.action.clientservice.infra.impl;

import com.trading.action.clientservice.domain.pojo.*;
import com.trading.action.clientservice.infra.core.AbstractInfraImpl;
import com.trading.action.clientservice.infra.dao.ActionnaireDao;
import com.trading.action.clientservice.infra.entity.ActionnaireEntity;
import com.trading.action.clientservice.infra.entity.CompteEntity;
import com.trading.action.clientservice.infra.facade.ActionnaireInfra;
import com.trading.action.clientservice.infra.facade.CompteInfra;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ActionnaireInfraImpl extends AbstractInfraImpl implements ActionnaireInfra {


    private final ActionnaireDao actionnaireDao;
    private final CompteInfra compteInfra;


    @Override
    public Actionnaire findByRef(String ref) {
        ActionnaireEntity actionnaireEntity = actionnaireDao.findByRef(ref);
        Actionnaire actionnaire = new Actionnaire();
        if (actionnaireEntity != null) {
            BeanUtils.copyProperties(actionnaireEntity, actionnaire);
            return actionnaire;
        }
        return null;
    }

    @Override
    public Actionnaire findByUsername(String username) {
        ActionnaireEntity actionnaireEntity = actionnaireDao.findByUsername(username);
        Actionnaire actionnaire = new Actionnaire();
        if (actionnaireEntity != null) {
            BeanUtils.copyProperties(actionnaireEntity, actionnaire);
            return actionnaire;
        }
        return null;
    }

    @Override
    public List<Portefeuille> getPortefeuilles(List<Action> actions) {
        List<Portefeuille> portefeuilles = new ArrayList<>();
        if (!actions.isEmpty()) {
            for (int i = 0; i < actions.size(); i++) {
                List<Price> prices = findPrixHestoryByDateAndEntreprise(actions.get(i).getCreatedAt(), actions.get(i).getRefEntreprise());
                Portefeuille portefeuille = new Portefeuille();
                List<PortefeuilleItem> portefeuilleItemList =new ArrayList<>();
                portefeuille.setPortefeuilleItemList(portefeuilleItemList);

                PortefeuilleItem portefeuilleItem = new PortefeuilleItem();
                portefeuilleItem.setDate(prices.get(0).getCreatedAt());
                portefeuilleItem.setPrix(prices.get(0).getPrix());
                portefeuilleItem.setPrixPerteOrProfit(prices.get(0).getPrix());

                portefeuille.setAction(actions.get(i));
                portefeuille.getPortefeuilleItemList().add(portefeuilleItem);
                portefeuilles.add(portefeuille);

                for (int j = 1; j < prices.size(); j++) {

                    PortefeuilleItem portefeuilleItem1 = new PortefeuilleItem();
                    portefeuilleItem1.setDate(prices.get(j).getCreatedAt());
                    portefeuilleItem1.setPrix(prices.get(j).getPrix());
                    portefeuilleItem1.setPrixPerteOrProfit(prices.get(j).getPrix().subtract(prices.get(j - 1).getPrix()));
                    portefeuille.getPortefeuilleItemList().add(portefeuilleItem1);
                }

            }
        }
        return portefeuilles;
    }

    @SneakyThrows
    private List<Price> findPrixHestoryByDateAndEntreprise(Instant date, String refEntreprise) {
        List<Price> prices = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Price p1 = new Price();
        p1.setPrix(new BigDecimal(100));
        p1.setCreatedAt(formatter.parse("04/22/2021").toInstant());

        Price p2 = new Price();
        p2.setPrix(new BigDecimal(150));
        p2.setCreatedAt(formatter.parse("04/29/2021").toInstant());

        Price p3 = new Price();
        p3.setPrix(new BigDecimal(50));
        p3.setCreatedAt(formatter.parse("05/22/2021").toInstant());

        Price p4 = new Price();
        p4.setPrix(new BigDecimal(1000));
        p4.setCreatedAt(formatter.parse("05/25/2021").toInstant());

        Price p5 = new Price();
        p5.setPrix(new BigDecimal(2000));
        p5.setCreatedAt(formatter.parse("06/11/2021").toInstant());

        Price p6 = new Price();
        p6.setPrix(new BigDecimal(1090));
        p6.setCreatedAt(formatter.parse("07/22/2021").toInstant());

        prices.add(p1);
        prices.add(p2);
        prices.add(p3);
        prices.add(p4);
        prices.add(p5);
        prices.add(p6);

        return prices;
    }

    @Override
    public int deleteByRef(String ref) {
        return actionnaireDao.deleteByRef(ref);
    }

    @Override
    public int save(Actionnaire actionnaire) {
        ActionnaireEntity actionnaireEntity = new ActionnaireEntity();
        BeanUtils.copyProperties(actionnaire, actionnaireEntity);
        actionnaireEntity.setCompteEntity(compteInfra.findCompteEntityByRef(actionnaire.getRefCompte()));
        if (findByRef(actionnaireEntity.getRef()) != null) {
            return -1;
        }

        actionnaireDao.save(actionnaireEntity);

        return 1;
    }

    @Override
    public int update(ActionnaireEntity actionnaireEntity) {
        if (findByRef(actionnaireEntity.getRef()) == null)
            return -1;
        actionnaireDao.save(actionnaireEntity);
        return 1;
    }

    @Override
    public List<ActionnaireEntity> findAll() {
        return actionnaireDao.findAll();
    }

    @Override
    public int update(Actionnaire actionnaire) {
        ActionnaireEntity actionnaireEntity = new ActionnaireEntity();
        BeanUtils.copyProperties(actionnaire, actionnaireEntity);
        return update(actionnaireEntity);
    }
}
