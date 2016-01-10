package dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import dropwizard.AppConfiguration;

public class HelloWorldApplication extends Application<AppConfiguration> {
	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) {
		    final HelloWorldResource resource = new HelloWorldResource(
		        configuration.getTemplate(),
		        configuration.getDefaultName()
		    );
		    final TemplateHealthCheck healthCheck =
		            new TemplateHealthCheck(configuration.getTemplate());
		        environment.healthChecks().register("template", healthCheck);
		      
		    environment.jersey().register(resource);
		
	}

}
