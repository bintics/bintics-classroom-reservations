package com.bintics.subscriptions.infraestructure.out.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SubscriptionEntityRepository extends CrudRepository<SubscriptionEntity, String> {

    @Query("SELECT s FROM SubscriptionEntity s " +
            "WHERE (:id IS NULL OR s.id = :id) " +
            "AND (:planId IS NULL OR s.planId = :planId) " +
            "AND (:cost IS NULL OR s.cost = :cost) " +
            "AND (:status IS NULL OR s.status = :status) " +
            "AND (:startDate IS NULL OR s.startDate >= :startDate) " +
            "AND (:endDate IS NULL OR s.startDate <= :endDate)")
    List<SubscriptionEntity> search(
            @Param("id") String id,
            @Param("planId") String planId,
            @Param("cost") Double cost,
            @Param("status") String status,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

}
