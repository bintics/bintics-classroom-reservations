package com.bintics.attendancecontrol.infrastructure.out.persistence;

import com.bintics.clients.infrastructure.percistence.jpa.ClientEntityRepository;
import com.bintics.context.assistcontrol.domain.ClientId;
import com.bintics.context.assistcontrol.domain.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AttendClientRepositoryImpl implements ClientRepository {

    private final ClientEntityRepository clientEntityRepository;

    @Override
    public boolean exists(ClientId clientId) {
        var result = this.clientEntityRepository.findById(clientId.value());
        return result.isPresent();
    }

}
