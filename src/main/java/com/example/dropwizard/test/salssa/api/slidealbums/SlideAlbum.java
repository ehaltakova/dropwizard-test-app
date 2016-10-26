package com.example.dropwizard.test.salssa.api.slidealbums;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Slide Album representation class.
 * Uses Builder pattern.
 * @author Elitza Haltakova
 *
 */
public class SlideAlbum {

	private String title;
	private String customer;
	private long modificationDate;
	private String locked;
	private String svg;
	private List<SlideAlbumFile> files;
	
	public SlideAlbum(Builder builder) {
		this.title = builder.title;
		this.customer = builder.customer;
		this.modificationDate = builder.modificationDate;
		this.locked = builder.lockedBy;
		this.svg = builder.svg;
		this.files = builder.files;
	}
	
	public static class Builder {
		
		private final String title;
		private final String customer;
		
		private long modificationDate;
		private String lockedBy;
		private String svg;
		private List<SlideAlbumFile> files;
		
		public Builder(String title, String customer) {
			this.title = title;
			this.customer = customer;
		}
		
		public SlideAlbum build() {
			return new SlideAlbum(this);
		}
		
		public Builder svg(String svgFileName) {
			this.svg = svgFileName;
			return this;
		}
		
		public Builder lockedBy(String lockedBy) {
			this.lockedBy = lockedBy;
			return this;
		}
		
		public Builder modificationDate(long modificationDate) {
			this.modificationDate = modificationDate;
			return this;
		}
		
		public Builder files(List<SlideAlbumFile> files) {
			this.files = files;
			return this;
		}
	}

	@JsonProperty
	public String getTitle() {
		return title;
	}

	@JsonProperty
	public String getCustomer() {
		return customer;
	}

	@JsonProperty
	public long getModificationDate() {
		return modificationDate;
	}

	@JsonProperty
	public String lockedBy() {
		return locked;
	}

	@JsonProperty
	public String getSvg() {
		return svg;
	}

	@JsonProperty
	public List<SlideAlbumFile> getFiles() {
		return files;
	}
	
	@Override 
	public String toString() {
		return "Slide album " + title + " [" + customer + "]"; 
	}
}
