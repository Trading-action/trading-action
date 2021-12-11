package com.trading.clientservice.application.dto;

import java.time.Instant;


public class CommissionIntermediareDto {
    private Long id;
    private  String ref;
    private  Instant createdAt;
    private  Instant updatedAt;
    private IntermediareDto intermediare;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public IntermediareDto getIntermediare() {
        return intermediare;
    }

    public void setIntermediare(IntermediareDto intermediare) {
        this.intermediare = intermediare;
    }
}
