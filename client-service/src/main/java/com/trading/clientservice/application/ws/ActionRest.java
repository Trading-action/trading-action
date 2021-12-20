package com.trading.clientservice.application.ws;

import com.trading.clientservice.application.dto.ActionDto;
import com.trading.clientservice.application.dto.CompteDto;
import com.trading.clientservice.application.dto.CompteTypeDto;
import com.trading.clientservice.domain.action.create.ActionCreateInput;
import com.trading.clientservice.domain.action.create.ActionCreateProcess;
import com.trading.clientservice.domain.compte.create.CompteCreateInput;
import com.trading.clientservice.domain.compte.create.CompteCreateProcess;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Action;
import com.trading.clientservice.domain.pojo.CompteType;
import com.trading.clientservice.infra.entity.ActionEntity;
import com.trading.clientservice.infra.entity.CompteTypeEntity;
import com.trading.clientservice.infra.facade.ActionInfra;
import com.trading.clientservice.infra.facade.CompteTypeInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actions")
@Tag(name = "actions", description = "Cette classe permet de tester les process de la action")
@Slf4j
@RequiredArgsConstructor
public class ActionRest {
     private  final ActionInfra actionInfra;
    private final ActionCreateProcess actionCreateProcess;

    @Operation(summary = "find actions")
    @GetMapping("/")
    public List<ActionEntity> findAll() {
        return actionInfra.findAll();
    }

    @Operation(summary = "save action")
    @PostMapping("/")
    public Result save(@RequestBody ActionDto actionDto) {
        ActionCreateInput actionCreatenput = ActionDto.toActionCreatenput(actionDto);
        return actionCreateProcess.execute(actionCreatenput);
    }

}
