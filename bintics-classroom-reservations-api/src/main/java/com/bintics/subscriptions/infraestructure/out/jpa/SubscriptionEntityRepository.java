package com.bintics.subscriptions.infraestructure.out.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionEntityRepository extends CrudRepository<SubscriptionEntity, String> {
}
