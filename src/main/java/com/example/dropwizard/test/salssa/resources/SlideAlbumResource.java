package com.example.dropwizard.test.salssa.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.example.dropwizard.test.salssa.api.SlideAlbum;
import com.example.dropwizard.test.salssa.db.SlideAlbumDAO;

@Path("/slidealbums")
@Produces(MediaType.APPLICATION_JSON)
public class SlideAlbumResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(SlideAlbumResource.class);

	private final SlideAlbumDAO dao;
	private final List<String> customers;
	
	public SlideAlbumResource(SlideAlbumDAO dao, List<String> customers) {
		this.dao = dao;
		this.customers = customers;
	}
	
	@GET
    @Timed
    public List<SlideAlbum> getSlideAlbums() {
		LOGGER.debug("get slidealbums");
		List<SlideAlbum> slidealbums = dao.getSlideAlbums(customers);
		return slidealbums;
	}
}
