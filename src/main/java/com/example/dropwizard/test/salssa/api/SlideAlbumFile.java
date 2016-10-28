package com.example.dropwizard.test.salssa.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Slide Album File representation class
 * @author Elitza Haltakova
 *
 */
public class SlideAlbumFile {
	String ext;
	String name;
	
	public SlideAlbumFile(String extension, String name) {
		this.ext = extension;
		this.name = name;
	}

	@JsonProperty
	public String getExt() {
		return ext;
	}

	@JsonProperty
	public String getName() {
		return name;
	}
}