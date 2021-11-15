package com.trading.action.clientservice.application.ws;

import com.trading.action.clientservice.application.dto.ActionnaireDto;
import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreateProcess;
import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreatenput;
import com.trading.action.clientservice.domain.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/actionnaire")
@Api("Cette classe permet de tester les process de la actionnaire")
public class ActionnaireRest {

    @ApiOperation("save process ")
    @PostMapping("/")
    public Result save(@RequestBody ActionnaireDto actionnaireDto) {
        ActionnaireCreatenput actionnaireCreatenput = ActionnaireDto.toActionnaireCreatenput(actionnaireDto);
        return actionnaireCreateProcess.execute(actionnaireCreatenput);
    }


    @Autowired
    private ActionnaireCreateProcess actionnaireCreateProcess;


}
