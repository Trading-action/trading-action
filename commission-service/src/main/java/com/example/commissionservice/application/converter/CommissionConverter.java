package com.example.commissionservice.application.converter;

import com.example.commissionservice.application.dto.CommissionDetailDto;
import com.example.commissionservice.application.dto.CommissionDto;
import com.example.commissionservice.application.utils.Converter;
import com.example.commissionservice.domain.pojo.Action;
import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.domain.pojo.CommissionDetail;


import java.util.List;

public class CommissionConverter extends Converter<Commission, CommissionDto> {
    public CommissionConverter() {
        super(CommissionConverter::convertToDto, CommissionConverter::convertToPojo);
    }

    private static CommissionDto convertToDto(Commission commission) {
        Converter<CommissionDetail, CommissionDetailDto> commissionDetailsConverter = new CommissionDetailsConverter();
        List<CommissionDetailDto> commissionDetails = commissionDetailsConverter.createFromPojos(commission.getCommissionDetails());
        return new CommissionDto(commission.getId(), commission.getRef(), commission.getCreatedAt(), commission.getUpdatedAt(), commission.getAction().getRef(), commission.getDateCommission(), commission.getTotalPrice(), commissionDetails);
    }

    private static Commission convertToPojo(CommissionDto commissionDto) {
        Converter<CommissionDetail, CommissionDetailDto> commissionDetailsConverter = new CommissionDetailsConverter();
        List<CommissionDetail> commissionDetails = commissionDetailsConverter.createFromDtos(commissionDto.getCommissionDetails());
        Action action = new Action(commissionDto.getRefAction());
        return new Commission(commissionDto.getId(), commissionDto.getRef(), commissionDto.getTotalPrice(), action, commissionDto.getCreatedAt(), commissionDto.getUpdatedAt(), commissionDto.getDateCommission(), commissionDetails);
    }
}
