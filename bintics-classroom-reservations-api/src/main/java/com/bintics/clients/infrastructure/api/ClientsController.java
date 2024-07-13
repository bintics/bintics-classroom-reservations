package com.bintics.clients.infrastructure.api;

import com.bintics.context.clients.application.RegisterClientRequest;
import com.bintics.context.clients.application.RegisterClientUseCase;
import com.bintics.context.clients.application.SearchClientsRequest;
import com.bintics.context.clients.application.SearchClientsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientsController {

    private final RegisterClientUseCase registerUseCase;

    private final SearchClientsUseCase searchUseCase;

    @PostMapping
    public void register(@RequestBody RegisterClientHttpRequest request) {
        this.registerUseCase.register(new RegisterClientRequest(
                request.getName(),
                request.getSurname(),
                request.getSecondSurname(),
                request.getBirthDate(),
                request.getGender()
        ));
    }

    @GetMapping
    public SearchClientHttpResponse search(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String secondSurname,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer offset
    ) {
        var response = this.searchUseCase.search(new SearchClientsRequest(
                id,
                name,
                surname,
                secondSurname,
                gender,
                limit,
                offset
        ));
        var total = response.getTotal();
        var items = response.getItems()
                .stream()
                .map(i -> new SearchClientHttpResponse.ClientHttpResponse(
                        i.getId(),
                        i.getName(),
                        i.getSurname(),
                        i.getSecondSurname(),
                        i.getBirthDate(),
                        i.getGender(),
                        i.getCreatedAt(),
                        i.getUpdatedAt()
                ))
                .collect(Collectors.toList());
        return new SearchClientHttpResponse(total, items);
    }

}
