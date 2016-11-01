package com.example.dropwizard.test.salssa;

import org.skife.jdbi.v2.DBI;

import com.example.dropwizard.test.salssa.api.SlideAlbum;
import com.example.dropwizard.test.salssa.api.SlideAlbumFile;
import com.example.dropwizard.test.salssa.db.SimpleSlideAlbumDAO;
import com.example.dropwizard.test.salssa.db.SlideAlbumDAO;
import com.example.dropwizard.test.salssa.resources.SimpleSlideAlbumResource;
import com.example.dropwizard.test.salssa.resources.SimpleSlideAlbumsResource;
import com.example.dropwizard.test.salssa.resources.SlideAlbumResource;
import com.example.dropwizard.test.salssa.resources.SlideAlbumsResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;

public class SalssaApp extends Application<SalssaAppConfiguration>{
	
	// create a new managed connection pool to the database, a health check for connectivity to the database, 
	// and a new SessionFactory instance for you to use in the DAO class
	HibernateBundle<SalssaAppConfiguration> hibernateBundle = new HibernateBundle<SalssaAppConfiguration>(SlideAlbum.class, SlideAlbumFile.class) { // mapped classes here, not in config!
		public DataSourceFactory getDataSourceFactory(SalssaAppConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};
	
	public static void main(String[] args) throws Exception {
		new SalssaApp().run(args);
	}
	
	@Override
	public String getName() {
		return "salssa"; // the name of the yaml file?
	}
	
	@Override
	public void initialize(Bootstrap<SalssaAppConfiguration> bootstrap) {
		// static files
		bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
		// JDBI management
		bootstrap.addBundle(new DBIExceptionsBundle()); // unwrap any thrown SQLException or DBIException instances automatically 		
		// migrations management
		bootstrap.addBundle(new MigrationsBundle<SalssaAppConfiguration>() {
			public DataSourceFactory getDataSourceFactory(SalssaAppConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
		// hibernate bundle		
		bootstrap.addBundle(hibernateBundle);
	}
	
	@Override
	public void run(SalssaAppConfiguration configuration, Environment environment) throws Exception {
		
		// db access
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2"); // creates managed DBI instance + health check for connectivity
		SimpleSlideAlbumDAO simpleDao = jdbi.onDemand(SimpleSlideAlbumDAO.class); // obtain and release connection automatically
		SlideAlbumDAO dao = new SlideAlbumDAO(hibernateBundle.getSessionFactory());
		
		// register resources
		environment.jersey().register(new SlideAlbumResource(dao));
		environment.jersey().register(new SlideAlbumsResource(dao));
		
		environment.jersey().register(new SimpleSlideAlbumResource(simpleDao));
		environment.jersey().register(new SimpleSlideAlbumsResource(simpleDao));
	}

}
