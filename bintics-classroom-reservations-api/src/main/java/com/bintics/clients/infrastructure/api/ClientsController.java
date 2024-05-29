package com.bintics.clients.infrastructure.api;

import com.bintics.context.clients.application.RegisterClientRequest;
import com.bintics.context.clients.application.RegisterClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientsController {

    private final RegisterClientUseCase useCase;

    @PostMapping
    public void register(@RequestBody RegisterClientHttpRequest request) {
        this.useCase.register(new RegisterClientRequest(
                request.getName(),
                request.getSurname(),
                request.getSecondSurname(),
                request.getBirthDate(),
                request.getGender()
        ));
    }

}
