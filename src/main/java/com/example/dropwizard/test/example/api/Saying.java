package com.example.dropwizard.test.example.api;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation class - converted from/to JSON (or other custom format) by the Jersey MessageBodyReader/MessageBodyWriter providers.
 * Serves as a resource's request/response (application entity).
 * Note: immutable (multiple threads in mind!)
 * 
 * {
 * 	"id": 1,
 * 	"content": "Hi!"
 * }
 * 
 * Note: follows JavaBean standard.
 *
 */
public class Saying {
    
	private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}