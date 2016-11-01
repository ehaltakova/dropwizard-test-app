package com.example.dropwizard.test.salssa.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.example.dropwizard.test.salssa.api.SlideAlbum;

@RegisterMapper(SlideAlbumSimpleMapper.class)
public interface SlideAlbumDAO {
	
	@SqlQuery("select * from slidealbum where title = :title and customer = :customer")
	SlideAlbum getSlideAlbum(@Bind("title") String title, @Bind("customer") String customer);

	@SqlQuery("select * from slidealbum where id = :id")
	SlideAlbum getSlideAlbumById(@Bind("id") long id);

	@SqlQuery("select * from slidealbum")
	List<SlideAlbum> getSlideAlbums();

}
