package com.example.commissionservice.application.ws;

import com.example.commissionservice.application.dto.CommissionDto;
import com.example.commissionservice.domain.commission.create.CommissionCreateInput;
import com.example.commissionservice.domain.commission.create.CommissionCreateProcess;
import com.example.commissionservice.domain.core.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commission")
@RequiredArgsConstructor
@Slf4j
@Tag(name="Commissions", description = "This class provides a RestAPI to test Commission services ")
public class CommissionRest {

    private final CommissionCreateProcess commissionCreateProcess;

    @PostMapping("/")
    @Operation(summary = "Save commission")
    public Result save(@RequestBody CommissionDto commissionDto){
        CommissionCreateInput commissionCreateInput = CommissionDto.toCommissionCreateInput(commissionDto);
        return commissionCreateProcess.execute(commissionCreateInput);
    }
}
