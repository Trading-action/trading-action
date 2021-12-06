package com.trading.action.clientservice.application.ws;

import com.trading.action.clientservice.application.dto.CompteDto;
import com.trading.action.clientservice.application.dto.CompteTypeDto;
import com.trading.action.clientservice.domain.pojo.Compte;
import com.trading.action.clientservice.domain.pojo.CompteType;
import com.trading.action.clientservice.infra.entity.CompteEntity;
import com.trading.action.clientservice.infra.entity.CompteTypeEntity;
import com.trading.action.clientservice.infra.facade.CompteInfra;
import com.trading.action.clientservice.infra.facade.CompteTypeInfra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-comptes")
@Api("Cette classe permet de tester les process de la type compte")
@Slf4j
@RequiredArgsConstructor
public class CompteTypeRest {
     private  final CompteTypeInfra compteTypeInfra;
    @ApiOperation("find type comptes ")
    @GetMapping("/")
    public List<CompteTypeEntity> findAll() {
        return compteTypeInfra.findAll();
    }

    @ApiOperation("save  type compte ")
    @PostMapping("/")
    public int save(@RequestBody CompteTypeDto compteTypeDto) {
        CompteType compteType = new CompteType();
        compteType.setRef(compteTypeDto.getRef());
        compteType.setLibelle(compteTypeDto.getLibelle());
        return compteTypeInfra.save(compteType);
    }

}
