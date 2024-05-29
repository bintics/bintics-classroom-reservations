package com.bintics.attendance.infrastructure.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column
    private String clientId;

    @Column(nullable = false)
    private String subscriptionId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutAt;

}
