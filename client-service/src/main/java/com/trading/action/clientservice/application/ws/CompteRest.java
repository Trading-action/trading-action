package com.trading.action.clientservice.application.ws;

import com.trading.action.clientservice.application.dto.CompteDto;
import com.trading.action.clientservice.domain.compte.create.CompteCreateProcess;
import com.trading.action.clientservice.domain.compte.create.CompteCreateInput;
import com.trading.action.clientservice.domain.core.Result;
import com.trading.action.clientservice.infra.entity.CompteEntity;
import com.trading.action.clientservice.infra.facade.CompteInfra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
@Api("Cette classe permet de tester les process de la compte")
@Slf4j
@RequiredArgsConstructor
public class CompteRest {
    private final CompteInfra compteInfra;
    private final CompteCreateProcess compteCreateProcess;

    @ApiOperation("save compte")
    @PostMapping("/")
    public Result save(@RequestBody CompteDto compteDto) {
        CompteCreateInput compteCreatenput = CompteDto.toCompteCreatenput(compteDto);
        return compteCreateProcess.execute(compteCreatenput);
    }

    @ApiOperation("find comptes ")
    @GetMapping("/")
    public List<CompteEntity> findAll() {
        return compteInfra.findAll();
    }


}
