package com.bintics.context.clients.domain;

import com.bintics.context.clients.application.SearchClientsRequest;
import com.bintics.context.clients.application.SearchClientsResponse;

public interface ClientSearcherRepository {

    SearchClientsResponse search(SearchClientsRequest request);

}
