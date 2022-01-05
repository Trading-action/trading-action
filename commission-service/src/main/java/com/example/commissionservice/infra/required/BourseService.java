package com.example.commissionservice.infra.required;

import com.example.commissionservice.domain.core.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BOURSE-SERVICE")
public interface BourseService {

    @GetMapping("/api/v1/bourse-service/actions/ref/{ref}")
    Result findActionByRef(@PathVariable String ref);

}
