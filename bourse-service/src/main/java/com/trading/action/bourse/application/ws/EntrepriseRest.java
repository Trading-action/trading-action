package com.trading.action.bourse.application.ws;

import com.trading.action.bourse.application.dto.EntrepriseDto;
import com.trading.action.bourse.domain.core.Result;
import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateInput;
import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateProcess;
import com.trading.action.bourse.domain.pojo.Entreprise;
import com.trading.action.bourse.infra.entity.EntrepriseEntity;
import com.trading.action.bourse.infra.facade.EntrepriseInfra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entreprise")
@Api("Cette classe permet de tester les process de la entreprise")
public class EntrepriseRest {
    @Autowired
    EntrepriseInfra entrepriseInfra;

    @ApiOperation("save a new company process ")
    @PostMapping("/")
    public Result save(@RequestBody EntrepriseDto entrepriseDto) {
        EntrepriseCreateInput entrepriseCreateInput = EntrepriseDto.toEntrepriseCreateInput(entrepriseDto);
        return entrepriseCreateProcess.execute(entrepriseCreateInput);
    }

    @ApiOperation("get all companies")
    @GetMapping("/")
    public List<EntrepriseEntity> findAll() {
        return entrepriseInfra.findAll();
    }


    @Autowired
    private EntrepriseCreateProcess entrepriseCreateProcess;
}
