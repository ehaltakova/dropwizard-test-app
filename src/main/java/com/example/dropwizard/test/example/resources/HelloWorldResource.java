package com.example.dropwizard.test.example.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.example.dropwizard.test.example.api.Saying;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);

	private final String template;
	private final String defaultName;
	private final AtomicLong counter; // cheap, thread-safe way of generating unique(ish) IDs.

	public HelloWorldResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
		LOGGER.debug("sayHello");
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
