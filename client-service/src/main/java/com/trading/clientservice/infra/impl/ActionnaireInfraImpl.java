package com.trading.clientservice.infra.impl;

import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.*;
import com.trading.clientservice.infra.core.AbstractInfraImpl;
import com.trading.clientservice.infra.dao.ActionnaireDao;
import com.trading.clientservice.infra.entity.ActionnaireEntity;
import com.trading.clientservice.infra.facade.ActionnaireInfra;
import com.trading.clientservice.infra.facade.CompteInfra;
import com.trading.clientservice.infra.required.EntrepriseService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ActionnaireInfraImpl extends AbstractInfraImpl implements ActionnaireInfra {


    private ActionnaireDao actionnaireDao;
    private CompteInfra compteInfra;
    private EntrepriseService entrepriseService;


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
    public Portefeuille getPortefeuilles(List<Action> actions) {
        Portefeuille portefeuille = new Portefeuille();
        if (!actions.isEmpty()) {
            portefeuille.setPortefeuilleItemList(new ArrayList<>());
            for (int i = 0; i < actions.size(); i++) {
                PriceHistory priceHistory = new PriceHistory();
                priceHistory.setDate(actions.get(i).getCreatedAt());
                priceHistory.setEntrepriseLibelle(actions.get(i).getReferenceEntreprise());
                Result<List<Price>, List<Price>> result = entrepriseService.findPrixHestoryByDateAndEntreprise(priceHistory);
                log.error("prices " + result.toString());
                if (result.getOutput() != null) {
                    List<Price> prices = result.getOutput();
                    PortefeuilleItem portefeuilleItem = new PortefeuilleItem();
                    List<PortefeuilleAction> portefeuilleActionList = new ArrayList<>();
                    portefeuilleItem.setPortefeuilleActionList(portefeuilleActionList);
                    PortefeuilleAction portefeuilleAction = new PortefeuilleAction();
                    portefeuilleAction.setDate(prices.get(0).getCreatedAt());
                    portefeuilleAction.setPrix(prices.get(0).getPrix());
                    portefeuilleAction.setPrixPerteOrProfit(prices.get(0).getPrix());
                    portefeuilleItem.setAction(actions.get(i));
                    portefeuilleItem.getPortefeuilleActionList().add(portefeuilleAction);
                    for (int j = 1; j < prices.size(); j++) {
                        PortefeuilleAction portefeuilleAction1 = new PortefeuilleAction();
                        portefeuilleAction1.setDate(prices.get(j).getCreatedAt());
                        portefeuilleAction1.setPrix(prices.get(j).getPrix());
                        portefeuilleAction1.setPrixPerteOrProfit(prices.get(j).getPrix().subtract(prices.get(0).getPrix()));
                        portefeuilleItem.getPortefeuilleActionList().add(portefeuilleAction1);
                    }
                    portefeuille.getPortefeuilleItemList().add(portefeuilleItem);
                }else{
                    return  null;
                }
            }
            return portefeuille;
        }
        return null;
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
