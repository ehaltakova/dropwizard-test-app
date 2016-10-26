package com.example.dropwizard.test.salssa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dropwizard.test.salssa.resources.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;

public class SalssaApp extends Application<SalssaAppConfiguration>{

	private static final Logger LOGGER = LoggerFactory.getLogger(SalssaApp.class);
	 
	public static void main(String[] args) throws Exception {
		LOGGER.debug("Test Logging");
		new SalssaApp().run(args);
	}
	
	@Override
	public String getName() {
		return "salssa"; // the name of the yaml file?
	}
	
	@Override
	public void initialize(Bootstrap<SalssaAppConfiguration> bootstrap) {
		 bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
	}
	
	@Override
	public void run(SalssaAppConfiguration configuration, Environment environment) throws Exception {
		
		// register resource
		final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
		environment.jersey().register(resource);
	}

}
