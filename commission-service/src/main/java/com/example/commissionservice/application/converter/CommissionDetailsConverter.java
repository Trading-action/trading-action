package com.example.commissionservice.application.converter;

import com.example.commissionservice.application.dto.CommissionDetailDto;
import com.example.commissionservice.application.dto.TypeCommissionDto;
import com.example.commissionservice.application.utils.Converter;
import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.domain.pojo.TypeCommission;


public class CommissionDetailsConverter extends Converter<CommissionDetail, CommissionDetailDto> {
    public CommissionDetailsConverter() {
        super(CommissionDetailsConverter::convertToDto, CommissionDetailsConverter::convertToPojo);
    }

    private static CommissionDetail convertToPojo(CommissionDetailDto commissionDetailDto) {
        TypeCommissionConverter typeCommissionConverter = new TypeCommissionConverter();
        TypeCommission typeCommission = typeCommissionConverter.convertFromDto(commissionDetailDto.getTypeCommissionDto());
        return new CommissionDetail(commissionDetailDto.getId(), commissionDetailDto.getRef(), commissionDetailDto.getCreatedAt(), commissionDetailDto.getUpdatedAt(), commissionDetailDto.getPrice(), typeCommission);
    }

    private static CommissionDetailDto convertToDto(CommissionDetail commissionDetail) {
        TypeCommissionConverter typeCommissionConverter = new TypeCommissionConverter();
        TypeCommissionDto typeCommissionDto = typeCommissionConverter.convertFromPojo(commissionDetail.getTypeCommission());
        return new CommissionDetailDto(commissionDetail.getId(), commissionDetail.getRef(), commissionDetail.getCreatedAt(), commissionDetail.getUpdatedAt(), typeCommissionDto, commissionDetail.getPrice());
    }

}
