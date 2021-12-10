package com.trading.clientservice.infra.dao;

import com.trading.clientservice.infra.entity.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao extends JpaRepository<ActionEntity,Long> {
    ActionEntity findByRef(String ref);

    List<ActionEntity> findByActionnaireUsername(String username);

    int deleteByRef(String ref);

    @Query("SELECT a.refEntreprise FROM ActionEntity a  WHERE a.actionnaire.username=?1")
    List<String> findEntreprises(String username);

    List<ActionEntity> findByRefEntrepriseAndActionnaireUsername(String refEnreprise, String username);
}
