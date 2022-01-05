package com.trading.clientservice.application.ws;

import com.trading.clientservice.application.dto.CompteTypeDto;
import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.CompteType;
import com.trading.clientservice.infra.entity.CompteTypeEntity;
import com.trading.clientservice.infra.facade.CompteTypeInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-comptes")
@Tag(name = "type-comptes", description = "Cette classe permet de tester les process de la type compte")
@Slf4j
@RequiredArgsConstructor
public class CompteTypeRest {
     private  final CompteTypeInfra compteTypeInfra;

    @Operation(summary = "find type comptes")
    @GetMapping("/")
    public List<CompteTypeEntity> findAll() {
        return compteTypeInfra.findAll();
    }

    @Operation(summary = "save type comptes")
    @PostMapping("/")
    public int save(@RequestBody CompteTypeDto compteTypeDto) {
        CompteType compteType = new CompteType();
        compteType.setRef(compteTypeDto.getRef());
        compteType.setLibelle(compteTypeDto.getLibelle());
        return compteTypeInfra.save(compteType);
    }

    @GetMapping("/ref/{ref}")
    @Operation(summary = "Find compte Type by Reference")
    public Result findByRef(@PathVariable String ref){
        Result result = new Result();
        CompteType compteType = compteTypeInfra.findByRef(ref);
        result.setOutput(compteType);
        return result;
    }

}
