package com.trading.clientservice.infra.required;

import com.trading.clientservice.domain.core.Result;
import com.trading.clientservice.domain.pojo.Price;
import com.trading.clientservice.domain.pojo.PriceHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "ENTREPRISE-SERVICE")
public interface EntrepriseService {

    @GetMapping("/api/v1/entreprise-service/price/history/")
    Result<List<Price>, List<Price>> findPrixHestoryByDateAndEntreprise(@RequestBody PriceHistory priceHistory);

    @GetMapping("/api/v1/entreprise-service/entreprise/{libelle}/")
     Result<String,String> findByLibelle(@PathVariable String libelle);

    @GetMapping("/api/v1/entreprise-service/entreprise/{company}/Percentage")
     Result<BigDecimal,BigDecimal> getSharePercentage(@PathVariable("company") String company, @RequestParam(value = "shares", required = false) BigDecimal shares);


}
