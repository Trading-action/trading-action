package com.trading.action.entreprise.infra.dao;

import com.trading.action.entreprise.infra.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PriceDao extends JpaRepository<PriceEntity, Long> {
    PriceEntity findByReference(String reference);
    List<PriceEntity> findFirstByEntreprise_Libelle(String libelle);
    int deleteByReference(String reference);

    @Query(value = "(SELECT p.* FROM Price_Entity  p, Entreprise_Entity ent WHERE ent.id = p.entreprise and ent.libelle = :libelle and p.created_At > :createdAt order by p.created_at ) UNION (SELECT p.* FROM Price_Entity  p, Entreprise_Entity ent WHERE ent.id = p.entreprise and ent.libelle = :libelle and p.created_at <= :createdAt order by p.created_at DESC LIMIT 1)", nativeQuery = true)
    List<PriceEntity> findHistory(@Param("libelle") String libelle,@Param("createdAt") Instant createdAt);

    @Query("select new java.lang.Boolean(count(*) > 0) from EntrepriseEntity ent, PriceEntity p where ent.libelle = :libelle and p.createdAt < :createdAt and ent.id = p.entreprise")
    Boolean hasOlderPrices(@Param("libelle") String libelle,@Param("createdAt") Instant createdAt);
}
