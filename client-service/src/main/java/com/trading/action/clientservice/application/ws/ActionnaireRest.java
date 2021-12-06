package com.trading.action.clientservice.application.ws;

import com.trading.action.clientservice.application.dto.ActionnaireDto;
import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreateProcess;
import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreateInput;
import com.trading.action.clientservice.domain.core.Result;
import com.trading.action.clientservice.domain.portefeuille.PortefeuilleInput;
import com.trading.action.clientservice.domain.portefeuille.PortefeuilleProcess;
import com.trading.action.clientservice.infra.dao.ActionDao;
import com.trading.action.clientservice.infra.entity.ActionEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actionnaire")
@Api("Cette classe permet de tester les process de la actionnaire")
@Slf4j
@RequiredArgsConstructor
public class ActionnaireRest {

   private  final ActionnaireCreateProcess actionnaireCreateProcess;
   private  final PortefeuilleProcess portefeuilleProcess;

    @ApiOperation("save process")
    @PostMapping("/")
    public Result save(@RequestBody ActionnaireDto actionnaireDto) {
        ActionnaireCreateInput actionnaireCreatenput = ActionnaireDto.toActionnaireCreatenput(actionnaireDto);
        return actionnaireCreateProcess.execute(actionnaireCreatenput);
    }

    @ApiOperation("get portefeuilles")
    @GetMapping("/portefeuilles/{username}")
    public Result save(@PathVariable String username) {
        PortefeuilleInput portefeuilleInput = new PortefeuilleInput();
        portefeuilleInput.setUsername(username);
        return portefeuilleProcess.execute(portefeuilleInput);
    }

    private final ActionDao actionDao;
    @ApiOperation("get portefeuilles")
    @GetMapping("/test/{username}")
    public List<ActionEntity> test(@PathVariable String username){
        return  actionDao.findByActionnaireUsername(username);
    }


}
