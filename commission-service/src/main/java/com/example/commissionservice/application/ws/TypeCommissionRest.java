package com.example.commissionservice.application.ws;

import com.example.commissionservice.application.dto.ApplicableTypeCommissionsDto;
import com.example.commissionservice.application.dto.TypeCommissionDto;
import com.example.commissionservice.domain.TypeCommission.create.TypeCommissionCreateInput;
import com.example.commissionservice.domain.TypeCommission.create.TypeCommissionCreateProcess;
import com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions.FindApplicableTypeCommissionsInput;
import com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions.FindApplicableTypeCommissionsProcess;
import com.example.commissionservice.domain.core.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/type_commission")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Commission Types", description = "This class provides a RestAPI to test Commission Types services ")
public class TypeCommissionRest {

    private final TypeCommissionCreateProcess typeCommissionCreateProcess;
    private final FindApplicableTypeCommissionsProcess findApplicableTypeCommissionsProcess;


    @PostMapping("/")
    @Operation(summary = "Save commission types")
    public Result save(@RequestBody TypeCommissionDto typeCommissionDto) {
        TypeCommissionCreateInput typeCommissionCreateInput = TypeCommissionDto.toTypeCommissionCreateInput(typeCommissionDto);
        return typeCommissionCreateProcess.execute(typeCommissionCreateInput);
    }

    @Operation(summary = "")
    @PostMapping("/applicable-commission-types")
    public Result findApplicableTypeCommissions(@RequestBody ApplicableTypeCommissionsDto applicableTypeCommissionsDto) {

        FindApplicableTypeCommissionsInput findApplicableTypeCommissionsInput = ApplicableTypeCommissionsDto.toFindApplicableTypeCommissionsInput(applicableTypeCommissionsDto);

        return findApplicableTypeCommissionsProcess.execute(findApplicableTypeCommissionsInput);
    }

    /*public Result findByRef(String ref){
        return
    }


    public delete()

    public update()

     */


}
