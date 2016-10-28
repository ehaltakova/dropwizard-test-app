package com.example.dropwizard.test.salssa;

import java.util.ArrayList;

import org.skife.jdbi.v2.DBI;

import com.example.dropwizard.test.salssa.db.SlideAlbumDAO;
import com.example.dropwizard.test.salssa.resources.SlideAlbumResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;

public class SalssaApp extends Application<SalssaAppConfiguration>{
	 
	public static void main(String[] args) throws Exception {
		new SalssaApp().run(args);
	}
	
	@Override
	public String getName() {
		return "salssa"; // the name of the yaml file?
	}
	
	@Override
	public void initialize(Bootstrap<SalssaAppConfiguration> bootstrap) {
		 bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
		 bootstrap.addBundle(new DBIExceptionsBundle()); // unwrap any thrown SQLException or DBIException instances automatically!
	}
	
	@Override
	public void run(SalssaAppConfiguration configuration, Environment environment) throws Exception {
		
		final DBIFactory factory = new DBIFactory();
		// creates managed DBI instance + health check for connectivity
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
		SlideAlbumDAO dao = jdbi.onDemand(SlideAlbumDAO.class);
		
		// register resource
		final SlideAlbumResource resource = new SlideAlbumResource(dao, new ArrayList<String>());
		environment.jersey().register(resource);
	}

}
