package com.trading.clientservice.application.ws;

import com.trading.clientservice.application.dto.CompteDto;
import com.trading.clientservice.domain.compte.create.CompteCreateInput;
import com.trading.clientservice.domain.compte.create.CompteCreateProcess;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Compte;
import com.trading.clientservice.infra.entity.CompteEntity;
import com.trading.clientservice.infra.facade.CompteInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
@Tag(name = "compte", description = "Cette classe permet de tester les process de la compte")
@Slf4j
@RequiredArgsConstructor
public class CompteRest {
    private final CompteInfra compteInfra;
    private final CompteCreateProcess compteCreateProcess;

    @Operation(summary = "save compte ")
    @PostMapping("/")
    public Result save(@RequestBody CompteDto compteDto) {
        CompteCreateInput compteCreatenput = CompteDto.toCompteCreatenput(compteDto);
        return compteCreateProcess.execute(compteCreatenput);
    }

    @Operation(summary = "find comptes")
    @GetMapping("/")
    public List<CompteEntity> findAll() {
        return compteInfra.findAll();
    }

    @GetMapping("/ref/{ref}")
    @Operation(summary = "Find Account by reference")
    public Result findByRef(@PathVariable String ref){
        Result result = new Result();
        Compte compte = compteInfra.findByRef(ref);
        result.setOutput(compte);
        return result;
    }


}
