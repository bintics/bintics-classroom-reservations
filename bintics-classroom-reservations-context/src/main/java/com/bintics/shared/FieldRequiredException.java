package com.bintics.shared;

public class FieldRequiredException extends RuntimeException {

    public FieldRequiredException(String fieldName) {
        super(String.format("%s field is required.", fieldName));
    }

}
