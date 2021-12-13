package com.trading.action.entreprise.application.ws;

import com.trading.action.entreprise.application.dto.PriceDto;
import com.trading.action.entreprise.application.dto.PriceHistoryDto;
import com.trading.action.entreprise.domain.core.Result;
import com.trading.action.entreprise.domain.price.change.PriceChangeInput;
import com.trading.action.entreprise.domain.price.change.PriceChangeProcess;
import com.trading.action.entreprise.domain.price.history.PriceHistoryByDateAndEntrepriseInput;
import com.trading.action.entreprise.domain.price.history.PriceHistoryByDateAndEntrepriseProcess;
import com.trading.action.entreprise.infra.entity.PriceEntity;
import com.trading.action.entreprise.infra.facade.PriceInfra;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
@Tag(name = "price", description = "Ce service permet de visualiser les prix de marché des actions d'une entreprise donnée et aussi l'historique")
public class PriceRest {
    @Autowired
    PriceInfra priceInfra;

    @Autowired
    PriceChangeProcess priceChangeProcess;

    @Autowired
    PriceHistoryByDateAndEntrepriseProcess priceHistoryByDateAndEntrepriseProcess;

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

    @Operation(summary = "Price history by instant and company name", description = "Price history for a company")
    @PostMapping("/history/")
    public Result priceHistory(@RequestBody PriceHistoryDto priceHistoryDtoDto) {
        PriceHistoryByDateAndEntrepriseInput priceHistoryInput = new PriceHistoryByDateAndEntrepriseInput();
        BeanUtils.copyProperties(priceHistoryDtoDto,priceHistoryInput);
        return priceHistoryByDateAndEntrepriseProcess.execute(priceHistoryInput);
    }
}
