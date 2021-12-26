package com.example.commissionservice.application.dto;


import com.example.commissionservice.domain.commission.calculate.CommissionCalculateInput;
import com.example.commissionservice.domain.pojo.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActionDto {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private ActionnaireDto actionnaire;
    private boolean inBourse;
    private BigDecimal prix;
    private String refEntreprise;

    public ActionDto(Long id, String ref, Instant createdAt, Instant updatedAt, boolean inBourse, BigDecimal prix, String refEntreprise) {
        this.id = id;
        this.ref = ref;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.inBourse = inBourse;
        this.prix = prix;
        this.refEntreprise = refEntreprise;
    }
}
