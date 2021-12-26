package com.example.commissionservice.application.ws;

import com.example.commissionservice.application.converter.CommissionDetailsConverter;
import com.example.commissionservice.application.dto.CommissionDetailDto;
import com.example.commissionservice.domain.commissionDetail.create.CommissionDetailCreateInput;
import com.example.commissionservice.domain.commissionDetail.create.CommissionDetailCreateProcess;
import com.example.commissionservice.domain.commissionDetail.findByCommissionRef.FindByCommissionRefInput;
import com.example.commissionservice.domain.commissionDetail.findByCommissionRef.FindByCommissionRefProcess;
import com.example.commissionservice.domain.core.Result;
import com.example.commissionservice.domain.pojo.CommissionDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commission-detail")
@RequiredArgsConstructor
@Tag(name = "Commission details", description = "This class provides a RestAPI to test Commission Details services ")
public class CommissionDetailsRest {

    private final CommissionDetailCreateProcess commissionDetailCreateProcess;

    private final FindByCommissionRefProcess findByCommissionRefProcess;

    @PostMapping("/")
    @Operation(summary = "Save commission detail")
    public Result save(@RequestBody CommissionDetailDto commissionDetailDto) {
        CommissionDetailsConverter commissionDetailsConverter = new CommissionDetailsConverter();
        CommissionDetail commissionDetail = commissionDetailsConverter.convertFromDto(commissionDetailDto);
        System.out.println("commissionDetail: " + commissionDetail);
        CommissionDetailCreateInput commissionDetailCreateInput = new CommissionDetailCreateInput();
        commissionDetailCreateInput.setCommissionDetail(commissionDetail);
        return commissionDetailCreateProcess.execute(commissionDetailCreateInput);
    }

    @GetMapping("/commission/{ref}")
    @Operation(summary = "find Commission Details By Commission Reference")
    public Result findByCommissionRef(@PathVariable String ref){
        FindByCommissionRefInput findByCommissionRefInput = new FindByCommissionRefInput();
        findByCommissionRefInput.setRefCommission(ref);
        return findByCommissionRefProcess.execute(findByCommissionRefInput);
    }

}
