package com.trading.action.bourse.application.ws;

import com.trading.action.bourse.domain.pojo.Price;
import com.trading.action.bourse.infra.entity.PriceEntity;
import com.trading.action.bourse.infra.facade.PriceInfra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
@Api("Cette classe permet de visualiser les prix de marché des actions d'une entreprise donnée")
public class PriceRest {
    @Autowired
    PriceInfra priceInfra;

    @ApiOperation("find history prices by entreprise libelle")
    @GetMapping("/entreprise/{libelle}")
    public List<PriceEntity> findByEntreprise(@PathVariable String libelle) {
        return priceInfra.findByEntreprise(libelle);
    }

    @ApiOperation("find all saved prices")
    @GetMapping("/")
    public List<PriceEntity> findAll() {
        return priceInfra.findAll();
    }
}
