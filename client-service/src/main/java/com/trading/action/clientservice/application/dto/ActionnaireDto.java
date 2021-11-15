package com.trading.action.clientservice.application.dto;


import com.trading.action.clientservice.domain.actionnaire.create.ActionnaireCreatenput;
import org.springframework.beans.BeanUtils;

import java.time.Instant;
import java.util.List;

public class ActionnaireDto {
    private Long id;
    private String ref;
    private Instant createdAt;
    private Instant updatedAt;
    private List<ActionDto> actions;
    private List<TransactionDto> transactions;
    private CompteDto compte;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ActionDto> getActions() {
        return actions;
    }

    public void setActions(List<ActionDto> actions) {
        this.actions = actions;
    }

    public CompteDto getCompte() {
        return compte;
    }

    public void setCompte(CompteDto compte) {
        this.compte = compte;
    }

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

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public static ActionnaireCreatenput toActionnaireCreatenput(ActionnaireDto actionnaireDto) {
        ActionnaireCreatenput actionnaireCreatenput = new ActionnaireCreatenput();
        if (actionnaireDto != null)
            BeanUtils.copyProperties(actionnaireDto, actionnaireCreatenput);
        return actionnaireCreatenput;
    }


}
