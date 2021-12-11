package com.trading.action.bourseservice.application.ws;

import com.trading.action.bourseservice.application.dto.PriceDto;
import com.trading.action.bourseservice.domain.core.Result;
import com.trading.action.bourseservice.domain.price.change.PriceChangeInput;
import com.trading.action.bourseservice.domain.price.change.PriceChangeProcess;
import com.trading.action.bourseservice.infra.entity.PriceEntity;
import com.trading.action.bourseservice.infra.facade.PriceInfra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
@Api("Cette classe permet de visualiser les prix de marché des actions d'une entreprise donnée")
public class PriceRest {
    @Autowired
    PriceInfra priceInfra;

    @Autowired
    PriceChangeProcess priceChangeProcess;

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

    @ApiOperation("change a price for a company share")
    @PostMapping("/")
    public Result create(@RequestBody PriceDto priceDto) {
        PriceChangeInput priceChangeInput = new PriceChangeInput();
        BeanUtils.copyProperties(priceDto,priceChangeInput);
        return priceChangeProcess.execute(priceChangeInput);
    }
}
