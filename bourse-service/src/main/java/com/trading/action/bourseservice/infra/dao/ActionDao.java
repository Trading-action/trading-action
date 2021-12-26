package com.trading.action.bourseservice.infra.dao;


import com.trading.action.bourseservice.infra.entity.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao extends JpaRepository<ActionEntity, Long> {
    ActionEntity findByReference(String ref);

    List<ActionEntity> findByUsernameActionnaire(String username);

    int deleteByReference(String ref);

    @Query("SELECT a.referenceEntreprise FROM ActionEntity a  WHERE a.usernameActionnaire=?1")
    List<String> findEntreprisesByUsernameActionnaire(String username);

    List<ActionEntity> findByReferenceEntrepriseAndAndUsernameActionnaire(String referecneEnreprise, String username);
}
