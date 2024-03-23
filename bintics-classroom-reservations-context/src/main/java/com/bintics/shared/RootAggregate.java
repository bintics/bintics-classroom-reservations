package com.bintics.shared;

import com.bintics.context.classroomreservations.domain.event.ReservedEvent;

import java.util.LinkedList;
import java.util.List;

public class RootAggregate {

    private List<DomainEvent> events = new LinkedList<>();

    protected void record(DomainEvent event) {
        this.events.add(event);
    }

    public List<DomainEvent> pullEvents() {
        var _events = this.events;
        this.events = new LinkedList<>();
        return _events;
    }

}
