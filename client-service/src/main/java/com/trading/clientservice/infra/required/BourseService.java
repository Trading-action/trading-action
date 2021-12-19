package com.trading.clientservice.infra.required;

import com.trading.clientservice.domain.pojo.Entreprise;
import com.trading.clientservice.domain.pojo.Price;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.util.List;

@FeignClient(name = "BOURSE-SERVICE")
public interface BourseService {

    @GetMapping("")
    List<Price> findPrixHestoryByDateAndEntreprise(Instant date, String refEntreprise);

    Entreprise findByRef(String ref);

}
