package com.oracle.devops.dropwizard.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorld {

    private String message;

    public HelloWorld() {
        // Needed by Jackson deserialization
    }

    public HelloWorld(String message) {
        this.message = message;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}