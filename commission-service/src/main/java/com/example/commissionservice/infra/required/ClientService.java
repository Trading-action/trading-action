package com.example.commissionservice.infra.required;

import com.example.commissionservice.domain.core.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientService {

   /* @GetMapping("/api/v1/client-service/ref/{ref}")
    Result findByRef(@PathVariable String ref);

    */
}
