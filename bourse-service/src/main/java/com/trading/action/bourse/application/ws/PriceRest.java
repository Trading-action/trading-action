package com.trading.action.bourse.application.ws;

import com.trading.action.bourse.application.dto.PriceDto;
import com.trading.action.bourse.domain.core.Result;
import com.trading.action.bourse.domain.price.change.PriceChangeInput;
import com.trading.action.bourse.domain.price.change.PriceChangeProcess;
import com.trading.action.bourse.infra.entity.PriceEntity;
import com.trading.action.bourse.infra.facade.PriceInfra;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
@Tag(name = "price", description = "Cette classe permet de visualiser les prix de marché des actions d'une entreprise donnée")
public class PriceRest {
    @Autowired
    PriceInfra priceInfra;

    @Autowired
    PriceChangeProcess priceChangeProcess;

    @Operation(summary = "Find Price by company libelle", description = "Price search by %company% libelle", tags = { "price" })
    @GetMapping("/entreprise/{libelle}")
    public List<PriceEntity> findByEntreprise(@PathVariable String libelle) {
        return priceInfra.findByEntreprise(libelle);
    }
    @Operation(summary = "Find All prices for all companies", description = "find all prices")
    @GetMapping("/")
    public List<PriceEntity> findAll() {
        return priceInfra.findAll();
    }

    @Operation(summary = "Price change", description = "Price change for a company")
    @PostMapping("/")
    public Result create(@RequestBody PriceDto priceDto) {
        PriceChangeInput priceChangeInput = new PriceChangeInput();
        BeanUtils.copyProperties(priceDto,priceChangeInput);
        return priceChangeProcess.execute(priceChangeInput);
    }
}
