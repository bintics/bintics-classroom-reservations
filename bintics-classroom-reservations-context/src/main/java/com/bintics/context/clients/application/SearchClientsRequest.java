package com.bintics.context.clients.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SearchClientsRequest {

    private final int defaultLimit = 10;
    private final int defaultOffset = 0;

    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private String surname;
    @Getter
    private String secondSurname;
    @Getter
    private String gender;

    private Integer limit;
    private Integer offset;

    public Integer getLimit() {
        if (limit == null) {
            limit = defaultLimit;
        }
        return limit;
    }

    public Integer getOffset() {
        if (offset == null) {
            offset = defaultOffset;
        }
        return offset;
    }

}
