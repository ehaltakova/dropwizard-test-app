package com.example.dropwizard.test.salssa;

import com.example.dropwizard.test.salssa.resurces.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SalssaApp extends Application<SalssaAppConfiguration>{

	public static void main(String[] args) throws Exception{
		new SalssaApp().run(args);
	}
	
	@Override
	public String getName() {
		return "salssa"; // the name of the yaml file?
	}
	
	@Override
	public void initialize(Bootstrap<SalssaAppConfiguration> bootstrap) {
		
	}
	
	@Override
	public void run(SalssaAppConfiguration configuration, Environment environment) throws Exception {
		
		// register resource
		final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
		environment.jersey().register(resource);
	}

}
