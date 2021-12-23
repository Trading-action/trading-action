package com.trading.clientservice.infra.required;

import com.trading.clientservice.domain.pojo.Action;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "BOURSE-SERVICE")
public interface BourseService {

    @GetMapping("/api/v1/actions/entreprise/{referecneEnreprise}/actionnaire/{username}")
    List<Action> findByReferenceEntrepriseAndAndUsernameActionnaire(@PathVariable String referecneEnreprise, @PathVariable String username);

    @GetMapping("/api/v1/actions/actionnaire/{username}/entreprises")
    List<String> findEntreprisesByUsernameActionnaire(@PathVariable String username);
}
