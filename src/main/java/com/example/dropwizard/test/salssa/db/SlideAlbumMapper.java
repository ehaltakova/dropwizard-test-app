package com.example.dropwizard.test.salssa.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.example.dropwizard.test.salssa.api.SlideAlbum;

public class SlideAlbumMapper implements ResultSetMapper<SlideAlbum> {
  
	public SlideAlbum map(int index, ResultSet r, StatementContext ctx) throws SQLException {
    
	  return new SlideAlbum.Builder(r.getString("title"), r.getString("customer"))
    		.modificationDate(r.getLong("modificationDate"))
    		.svg(r.getString("svg"))
    		.lockedBy(r.getString("locked"))
    		.build();
  }
}