package com.example.commissionservice.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommissionDetailDto {
    Long id;
    String ref;
    Instant createdAt;
    Instant updatedAt;
    TypeCommissionDto typeCommissionDto;
    BigDecimal price;

}
