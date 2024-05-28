package com.bintics.subscriptions.infraestructure.out.jpa;

import com.bintics.context.subscriptions.domain.SubscriptionId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEntity implements Serializable {

    @Id
    private String id;

    @Getter
    private String clientId;

    @Getter
    private Double cost;

    @Getter
    private Date startDate;

    @Getter
    private Date endDate;

}
