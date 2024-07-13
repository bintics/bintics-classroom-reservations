package com.bintics.clients.infrastructure.percistence.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientEntityRepository extends CrudRepository<ClientEntity, String> {

    @Query("SELECT c FROM ClientEntity c WHERE " +
            "(:id IS NULL OR c.id = :id) AND " +
            "(:name IS NULL OR c.name LIKE %:name%) AND " +
            "(:surname IS NULL OR c.surname LIKE %:surname%) AND " +
            "(:secondSurname IS NULL OR c.secondSurname LIKE %:secondSurname%) AND " +
            "(:gender IS NULL OR c.gender = :gender)")
    Page<ClientEntity> search(
            @Param("id") String id,
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("secondSurname") String secondSurname,
            @Param("gender") String gender,
            Pageable pageable
    );

}
