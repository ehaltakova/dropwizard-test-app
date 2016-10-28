package com.example.dropwizard.test.salssa.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

import com.example.dropwizard.test.salssa.api.SlideAlbum;

public interface SlideAlbumDAO {
	
	@SqlQuery("select * from slidealbums where customer in (= :customers)")
	List<SlideAlbum> getSlideAlbums(@Bind("customers") List<String> customers);
}
