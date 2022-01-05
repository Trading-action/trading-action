package com.example.commissionservice.application.ws;

import com.example.commissionservice.application.dto.CalculateCommissionDto;
import com.example.commissionservice.application.dto.CommissionDto;
import com.example.commissionservice.domain.commission.calculate.CommissionCalculateInput;
import com.example.commissionservice.domain.commission.calculate.CommissionCalculateProcess;
import com.example.commissionservice.domain.commission.create.CommissionCreateInput;
import com.example.commissionservice.domain.commission.create.CommissionCreateProcess;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.infra.facade.CommissionInfra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commission")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Commissions", description = "This class provides a RestAPI to test Commission services ")
public class CommissionRest {

    private final CommissionCreateProcess commissionCreateProcess;
    private final CommissionCalculateProcess commissionCalculateProcess;

    @Autowired
    private CommissionInfra commissionInfra;

    @PostMapping("/")
    @Operation(summary = "Save commission")
    public Result save(@RequestBody CommissionDto commissionDto) {
        CommissionCreateInput commissionCreateInput = CommissionDto.toCommissionCreateInput(commissionDto);
        return commissionCreateProcess.execute(commissionCreateInput);
    }

    @PostMapping("/calculate")
    @Operation(summary = "Calculate commission of a given action and a given account in the current date and save it with it's details")
    public Result calculateCommission(@RequestBody CalculateCommissionDto calculateCommissionDto) {
        CommissionCalculateInput commissionCalculateInput = CalculateCommissionDto.toCommissionCalculateInput(calculateCommissionDto);
        return commissionCalculateProcess.execute(commissionCalculateInput);
    }

    // TODO: Create get Commission By Ref

    // TODO: Create get Commission By RefAction and AccountRef

    // TODO: Create get Commission By RefAction and AccountRef and Operation Date

    @GetMapping("/")
    @Operation(summary = "Find All Commissions")
    public Result findAll() {
        Result result = new Result();
        List<Commission> commissions = commissionInfra.findAll();
        result.setOutput(commissions);
        return result;
    }

}
