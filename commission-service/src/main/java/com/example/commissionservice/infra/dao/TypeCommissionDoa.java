package com.example.commissionservice.infra.dao;

import com.example.commissionservice.infra.entity.TypeCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TypeCommissionDoa extends JpaRepository<TypeCommissionEntity, Long> {

    @Query(value = "SELECT tc FROM TypeCommissionEntity tc WHERE tc.applicationDateMax >= :operationDate AND tc.applicationDateMin < :operationDate AND tc.operationType = :operationType AND tc.refTypeCompte = :refTypeCompte")
    List<TypeCommissionEntity> findApplicableTypeCommissionEntities(@Param("operationDate") Instant operationDate, @Param("operationType") String operationType, @Param("refTypeCompte") String refTypeCompte);

    TypeCommissionEntity findByRef(String ref);

}
