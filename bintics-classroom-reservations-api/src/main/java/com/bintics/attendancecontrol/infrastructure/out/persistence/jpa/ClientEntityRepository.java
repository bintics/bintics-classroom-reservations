package com.bintics.attendancecontrol.infrastructure.out.persistence.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends CrudRepository<ClientEntity, String> {
}
