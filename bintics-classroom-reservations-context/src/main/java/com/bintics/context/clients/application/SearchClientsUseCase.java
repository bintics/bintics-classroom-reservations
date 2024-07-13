package com.bintics.context.clients.application;

import com.bintics.context.clients.domain.ClientSearcherRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchClientsUseCase {

    private final ClientSearcherRepository searcherRepository;

    public SearchClientsResponse search(SearchClientsRequest request) {
        return this.searcherRepository.search(request);
    }

}
