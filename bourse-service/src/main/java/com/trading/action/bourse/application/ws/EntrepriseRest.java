package com.trading.action.bourse.application.ws;

import com.trading.action.bourse.application.dto.EntrepriseDto;
import com.trading.action.bourse.domain.core.Result;
import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateInput;
import com.trading.action.bourse.domain.entreprise.create.EntrepriseCreateProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/entreprise")
@Api("Cette classe permet de tester les process de la entreprise")
public class EntrepriseRest {

    @ApiOperation("save process ")
    @PostMapping("/")
    public Result save(@RequestBody EntrepriseDto entrepriseDto) {
        EntrepriseCreateInput entrepriseCreateInput = EntrepriseDto.toEntrepriseCreateInput(entrepriseDto);
        return entrepriseCreateProcess.execute(entrepriseCreateInput);
    }


    @Autowired
    private EntrepriseCreateProcess entrepriseCreateProcess;
}
