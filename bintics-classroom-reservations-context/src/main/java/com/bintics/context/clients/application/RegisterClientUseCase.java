package com.bintics.context.clients.application;

import com.bintics.context.clients.domain.Client;
import com.bintics.context.clients.domain.ClientRepository;
import com.bintics.shared.DomainEventPublisher;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterClientUseCase {

    private final DomainEventPublisher domainEventPublisher;
    private final ClientRepository repository;

    public void register(RegisterClientRequest request) {
        var client = Client.register(
                request.getName(),
                request.getSurname(),
                request.getSecondSurname(),
                request.getBirthDate(),
                request.getGender()
        );
        this.repository.save(client);
        this.domainEventPublisher.publish(client.pullEvents());
    }

}
