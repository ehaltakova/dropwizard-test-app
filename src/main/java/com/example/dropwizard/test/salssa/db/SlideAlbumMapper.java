package com.example.dropwizard.test.salssa.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.example.dropwizard.test.salssa.api.SlideAlbum;
import com.example.dropwizard.test.salssa.api.SlideAlbumFile;

public class SlideAlbumMapper implements ResultSetMapper<SlideAlbum> {
  
	public SlideAlbum map(int index, ResultSet r, StatementContext ctx) throws SQLException {
    
	  return new SlideAlbum.Builder(r.getString("title"), r.getString("customer"))
    		.modificationDate(r.getLong("modificationDate"))
    		.svg(r.getString("svg"))
    		.files(Arrays.asList(new SlideAlbumFile(r.getString("ext"), r.getString("name"))))
    		.lockedBy(r.getString("locked"))
    		.build();
  }
}