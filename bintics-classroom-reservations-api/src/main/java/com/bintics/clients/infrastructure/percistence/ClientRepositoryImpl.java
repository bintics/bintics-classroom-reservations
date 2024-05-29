package com.bintics.clients.infrastructure.percistence;

import com.bintics.clients.infrastructure.percistence.jpa.ClientEntity;
import com.bintics.clients.infrastructure.percistence.jpa.ClientEntityRepository;
import com.bintics.context.clients.domain.Client;
import com.bintics.context.clients.domain.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientEntityRepository repository;

    @Override
    public void save(Client client) {
        var entity = new ClientEntity(
                client.id(),
                client.name(),
                client.surname(),
                client.secondSurname(),
                client.gender(),
                client.birthDate(),
                client.createdAt(),
                client.updatedAt()
        );
        this.repository.save(entity);
    }

}
