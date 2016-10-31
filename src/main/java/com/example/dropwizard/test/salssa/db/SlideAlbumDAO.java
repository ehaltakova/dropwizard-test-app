package com.example.dropwizard.test.salssa.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.example.dropwizard.test.salssa.api.SlideAlbum;

@RegisterMapper(SlideAlbumMapper.class)
public interface SlideAlbumDAO {
	
	@SqlQuery("select * from slidealbum join slidealbumfile on files = slidealbumfile.id where title = :title and customer = :customer")
	SlideAlbum getSlideAlbum(@Bind("title") String title, @Bind("customer") String customer);

}
