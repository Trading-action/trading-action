package com.example.commissionservice.application.dto;

import com.example.commissionservice.domain.TypeCommission.create.TypeCommissionCreateInput;
import com.example.commissionservice.domain.TypeCommission.findApplicableTypeCommissions.FindApplicableTypeCommissionsInput;
import com.example.commissionservice.domain.pojo.CompteType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeCommissionDto {
    Long id;
    String ref;
    Instant createdAt;
    Instant updatedAt;
    String label;
    Instant applicationDateMin;
    Instant applicationDateMax;
    String refCompteType;
    Float percentage;
    boolean tva;
    double minimal;
    String operationType;

    public static FindApplicableTypeCommissionsInput toFindApplicableTypeCommissionsInput(Instant operationDate) {
        FindApplicableTypeCommissionsInput findApplicableTypeCommissionsInput = new FindApplicableTypeCommissionsInput();
        findApplicableTypeCommissionsInput.setOperationDate(operationDate);
        return findApplicableTypeCommissionsInput;
    }

    @Override
    public String toString() {
        return "TypeCommissionDto{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", label='" + label + '\'' +
                ", applicationDateMin=" + applicationDateMin +
                ", applicationDateMax=" + applicationDateMax +
                ", refCompteType='" + refCompteType + '\'' +
                ", percentage=" + percentage +
                ", tva=" + tva +
                ", minimal=" + minimal +
                ", operationType=" + operationType +
                '}';
    }

    public static TypeCommissionCreateInput toTypeCommissionCreateInput(TypeCommissionDto typeCommissionDto) {
        TypeCommissionCreateInput typeCommissionCreateInput = new TypeCommissionCreateInput();
        BeanUtils.copyProperties(typeCommissionDto, typeCommissionCreateInput);
        typeCommissionCreateInput.setCompteType(new CompteType(typeCommissionDto.getRefCompteType()));
        return typeCommissionCreateInput;
    }
}
