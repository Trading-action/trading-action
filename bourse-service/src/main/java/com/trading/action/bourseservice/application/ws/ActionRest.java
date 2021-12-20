package com.trading.action.bourseservice.application.ws;

import com.trading.action.bourseservice.application.dto.ActionDto;
import com.trading.action.bourseservice.domain.core.Result;
import com.trading.action.bourseservice.domain.create.ActionCreateInput;
import com.trading.action.bourseservice.domain.create.ActionCreateProcess;
import com.trading.action.bourseservice.infra.entity.ActionEntity;
import com.trading.action.bourseservice.infra.facade.ActionInfra;
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
    private final ActionInfra actionInfra;
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
