package com.example.dropwizard.test.salssa.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.example.dropwizard.test.salssa.api.SlideAlbum;
import com.example.dropwizard.test.salssa.db.SlideAlbumDAO;

@Path("/slidealbum")
@Produces(MediaType.APPLICATION_JSON)
public class SlideAlbumResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(SlideAlbumResource.class);

	private final SlideAlbumDAO dao;
	
	public SlideAlbumResource(SlideAlbumDAO dao, String title, String customer) {
		this.dao = dao;
	}
	
	@GET
    @Timed
    public SlideAlbum getSlideAlbum(@QueryParam("title") String title, @QueryParam("customer") String customer) {
		LOGGER.debug("get slidealbum by title: " + title);
		SlideAlbum slidealbum = dao.getSlideAlbum(title, customer);
		return slidealbum;
	}
	
	@GET
	@Path("{id}")
    @Timed
    public SlideAlbum getSlideAlbumById(@PathParam("id") long id) {
		LOGGER.debug("get slidealbum by id : " + id);
		SlideAlbum slidealbum = dao.getSlideAlbumById(id);
		return slidealbum;
	}
}
