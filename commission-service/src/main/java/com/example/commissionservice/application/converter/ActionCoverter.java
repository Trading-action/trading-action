package com.example.commissionservice.application.converter;

import com.example.commissionservice.application.dto.ActionDto;
import com.example.commissionservice.application.dto.CommissionDetailDto;
import com.example.commissionservice.application.dto.CommissionDto;
import com.example.commissionservice.application.utils.Converter;
import com.example.commissionservice.domain.pojo.Action;
import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.domain.pojo.CommissionDetail;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;

public class ActionCoverter extends Converter<Action, ActionDto> {
    public ActionCoverter() {
        super(ActionCoverter::convertToDto, ActionCoverter::convertToPojo);
    }

    private static ActionDto convertToDto(Action action) {
        return new ActionDto(action.getId(), action.getRef(), action.getCreatedAt(), action.getUpdatedAt(), action.isInBourse(), action.getPrix(), action.getRefEntreprise());
    }

    private static Action convertToPojo(ActionDto actionDto) {
        return new Action(actionDto.getId(), actionDto.getRef(), actionDto.getCreatedAt(), actionDto.getUpdatedAt(), actionDto.isInBourse(), actionDto.getRefEntreprise(), actionDto.getPrix());
    }
}
