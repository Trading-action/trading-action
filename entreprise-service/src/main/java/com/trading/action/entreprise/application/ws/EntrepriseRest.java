package com.trading.action.entreprise.application.ws;

import com.trading.action.entreprise.application.dto.EntrepriseDto;
import com.trading.action.entreprise.domain.core.Result;
import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateInput;
import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateProcess;
import com.trading.action.entreprise.infra.entity.EntrepriseEntity;
import com.trading.action.entreprise.infra.facade.EntrepriseInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entreprise")
@Tag(name = "Entreprise",description = "Cette classe permet de tester les process de la entreprise")
public class EntrepriseRest {
    @Autowired
    EntrepriseInfra entrepriseInfra;

    @Operation(summary = "save a new company process ")
    @PostMapping("/")
    public Result save(@RequestBody EntrepriseDto entrepriseDto) {
        EntrepriseCreateInput entrepriseCreateInput = EntrepriseDto.toEntrepriseCreateInput(entrepriseDto);
        return entrepriseCreateProcess.execute(entrepriseCreateInput);
    }

   @Operation(summary = "get all companies")
    @GetMapping("/")
    public List<EntrepriseEntity> findAll() {
        return entrepriseInfra.findAll();
    }


    @Autowired
    private EntrepriseCreateProcess entrepriseCreateProcess;
}
