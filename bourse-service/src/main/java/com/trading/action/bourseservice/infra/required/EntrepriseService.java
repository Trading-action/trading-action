package com.trading.action.bourseservice.infra.required;

import com.trading.action.bourseservice.domain.core.Result;
import com.trading.action.bourseservice.domain.pojo.Entreprise;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENTREPRISE-SERVICE")
public interface EntrepriseService {
    @GetMapping("/api/v1/entreprise-service/entreprise/{libelle}/")
    Result<Entreprise,Entreprise> findByReference(@PathVariable String libelle);
}
