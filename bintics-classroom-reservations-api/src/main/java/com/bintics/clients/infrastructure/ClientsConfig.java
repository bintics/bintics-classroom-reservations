package com.bintics.clients.infrastructure;

import com.bintics.context.clients.application.RegisterClientUseCase;
import com.bintics.context.clients.application.SearchClientsUseCase;
import com.bintics.context.clients.domain.ClientRepository;
import com.bintics.context.clients.domain.ClientSearcherRepository;
import com.bintics.shared.DomainEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfig {

    @Bean
    public RegisterClientUseCase registerClientUseCase(DomainEventPublisher domainEventPublisher, ClientRepository repository) {
        return new RegisterClientUseCase(domainEventPublisher, repository);
    }

    @Bean
    public SearchClientsUseCase searcher(ClientSearcherRepository searcherRepository) {
        return new SearchClientsUseCase(searcherRepository);
    }

}
