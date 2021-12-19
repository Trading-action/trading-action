package com.trading.clientservice.infra.required;

import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Price;
import com.trading.clientservice.domain.pojo.PriceHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ENTREPRISE-SERVICE")
public interface EntrepriseService {

    @GetMapping("/api/v1/price/history/")
    Result<List<Price>,List<Price>>  findPrixHestoryByDateAndEntreprise(@RequestBody  PriceHistory priceHistory);


   // Entreprise findByRef(String ref);

}
