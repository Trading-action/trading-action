package com.trading.action.bourseservice.infra.required;

import com.trading.action.bourseservice.domain.core.Result;
import com.trading.action.bourseservice.domain.pojo.Actionnaire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACTIONNAIRE-SERVICE")
public interface ActionnaireService {
    @GetMapping("")
    Result<Actionnaire, Actionnaire> findByUsername(@PathVariable String username);
}
