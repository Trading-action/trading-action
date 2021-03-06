package com.trading.clientservice.application.ws;

import com.trading.clientservice.application.dto.ActionnaireDto;
import com.trading.clientservice.domain.actionnaire.create.ActionnaireCreateInput;
import com.trading.clientservice.domain.actionnaire.create.ActionnaireCreateProcess;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Actionnaire;
import com.trading.clientservice.domain.portefeuille.PortefeuilleInput;
import com.trading.clientservice.domain.portefeuille.PortefeuilleProcess;
import com.trading.clientservice.infra.facade.ActionnaireInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/actionnaires")
@Tag(name = "actionnaire", description = "Cette classe permet de tester les process de la actionnaire")
@Slf4j
@RequiredArgsConstructor
public class ActionnaireRest {

   private  final ActionnaireCreateProcess actionnaireCreateProcess;
   private  final PortefeuilleProcess portefeuilleProcess;
   private  final ActionnaireInfra actionnaireInfra;

    @Operation(summary = "save process ")
    @PostMapping("/")
    public Result save(@RequestBody ActionnaireDto actionnaireDto) {
        ActionnaireCreateInput actionnaireCreatenput = ActionnaireDto.toActionnaireCreatenput(actionnaireDto);
        return actionnaireCreateProcess.execute(actionnaireCreatenput);
    }

    @Operation(summary = "get portefeuilles ")
    @GetMapping("/portefeuilles/{username}")
    public Result getPortefeuilles(@PathVariable String username) {
        PortefeuilleInput portefeuilleInput = new PortefeuilleInput();
        portefeuilleInput.setUsername(username);
        return portefeuilleProcess.execute(portefeuilleInput);
    }

    @Operation(summary = "findByUsername ")
    @GetMapping("/{username}")
    public Actionnaire findByUsername(@PathVariable String username){
       return  actionnaireInfra.findByUsername(username);
    }


}
