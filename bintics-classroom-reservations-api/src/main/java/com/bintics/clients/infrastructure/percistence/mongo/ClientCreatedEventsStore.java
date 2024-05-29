package com.bintics.clients.infrastructure.percistence.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCreatedEventsStore extends MongoRepository<ClientRegisteredDocument, String> {
}
