package com.trading.action.entreprise.application.ws;

import com.trading.action.entreprise.application.dto.EntrepriseDto;
import com.trading.action.entreprise.application.dto.SecteurDto;
import com.trading.action.entreprise.domain.core.Result;
import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateInput;
import com.trading.action.entreprise.domain.pojo.Secteur;
import com.trading.action.entreprise.infra.entity.EntrepriseEntity;
import com.trading.action.entreprise.infra.entity.SecteurEntity;
import com.trading.action.entreprise.infra.facade.EntrepriseInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.trading.action.secteur.infra.facade.SecteurInfra;

import java.util.List;

@RestController
@RequestMapping("secteur")
@Tag(name = "Secteur", description = "Ce service permet de gérer les secteurs d'entreprise")
public class SecteurRest {

    @Autowired
    SecteurInfra secteurInfra;

    @Operation(summary = "save a new sector")
    @PostMapping("/")
    public Result save(@RequestBody SecteurDto secteurDto) {
        Secteur secteur = new Secteur();
        Result result = new Result();
        BeanUtils.copyProperties(secteurDto,secteur);
        secteurInfra.save(secteur);
        result.addInfoMessage(secteurInfra.getMessage("sector.created"));
        return result;
    }

    @Operation(summary = "get all companies")
    @GetMapping("/")
    public List<SecteurEntity> findAll() {
        return secteurInfra.findAll();
    }
}
