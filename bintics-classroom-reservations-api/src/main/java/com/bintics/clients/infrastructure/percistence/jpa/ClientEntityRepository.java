package com.bintics.clients.infrastructure.percistence.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends CrudRepository<ClientEntity, String> {
}
