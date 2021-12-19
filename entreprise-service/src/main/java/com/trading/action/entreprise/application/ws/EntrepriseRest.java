package com.trading.action.entreprise.application.ws;

import com.trading.action.entreprise.application.dto.EntrepriseDto;
import com.trading.action.entreprise.domain.core.Result;
import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateInput;
import com.trading.action.entreprise.domain.entreprise.create.EntrepriseCreateProcess;
import com.trading.action.entreprise.domain.pojo.Entreprise;
import com.trading.action.entreprise.infra.entity.EntrepriseEntity;
import com.trading.action.entreprise.infra.facade.EntrepriseInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
    public Result findAll() {
        Result result = new Result();
        result.setOutput(entrepriseInfra.findAll());
        return result;
    }

    @Operation(summary = "find by libelle")
    @GetMapping("/{libelle}/")
    public Result findByLibelle(@PathVariable String libelle) {
        Entreprise entreprise = entrepriseInfra.findByLibelle(libelle);
        Result result = new Result();
        if(entreprise == null){
            result.addErrorMessage(entrepriseInfra.getMessage("entreprise.not_found"));
        }else{
            result.setOutput(entrepriseInfra.findByLibelle(libelle));
        }
        return result;
    }

    @Operation(summary = "get client shares percentage")
    @GetMapping("/{company}/Percentage")
    public Result getSharePercentage(@PathVariable("company") String company,@RequestParam(value = "shares", required = false)BigDecimal shares){
        Entreprise entreprise = entrepriseInfra.findByLibelle(company);
        Result result = new Result();
        if(entreprise == null){
            result.addErrorMessage(entrepriseInfra.getMessage("entreprise.not_found"));
        }else{
            if (shares == null || shares.equals(0)) {
                result.setOutput(entreprise.getNombreAction());
            } else {
                result.setOutput(shares.multiply(new BigDecimal(100)).divide(entreprise.getNombreAction(), MathContext.DECIMAL128));
            }
        }
        return result;
    }

    @Autowired
    private EntrepriseCreateProcess entrepriseCreateProcess;
}