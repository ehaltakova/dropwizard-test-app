package com.example.dropwizard.test.salssa.api;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation
 * POJO - immutable (multiple threads in mind)!
 * {
 * 	"id": 1,
 * 	"content": "Hi!"
 * }
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