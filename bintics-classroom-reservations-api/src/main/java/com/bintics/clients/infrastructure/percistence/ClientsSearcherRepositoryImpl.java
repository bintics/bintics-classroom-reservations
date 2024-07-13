package com.bintics.clients.infrastructure.percistence;

import com.bintics.clients.infrastructure.percistence.jpa.ClientEntityRepository;
import com.bintics.context.clients.application.SearchClientsRequest;
import com.bintics.context.clients.application.SearchClientsResponse;
import com.bintics.context.clients.domain.ClientSearcherRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
@AllArgsConstructor
public class ClientsSearcherRepositoryImpl implements ClientSearcherRepository {

    private final ClientEntityRepository clientEntityRepository;

    @Override
    @Transactional
    public SearchClientsResponse search(SearchClientsRequest request) {
        int page = request.getOffset() / request.getLimit();
        int size = request.getLimit();
        var pageable = this.clientEntityRepository.search(
                request.getId(),
                request.getName(),
                request.getSurname(),
                request.getSecondSurname(),
                request.getGender(),
                PageRequest.of(page, size)
        );
        var total = pageable.getTotalElements();
        var items = pageable.stream().map(e -> new SearchClientsResponse.ClientResponse(
                e.getId(),
                e.getName(),
                e.getSurname(),
                e.getSecondSurname(),
                e.getBirthDate(),
                e.getGender(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        )).toList();
        return new SearchClientsResponse(total, items);
    }

}
