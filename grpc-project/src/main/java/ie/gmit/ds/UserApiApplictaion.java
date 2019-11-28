package ie.gmit.ds;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiApplictaion extends Application<UserApiConfig> {

    public static void main(String[] args) throws Exception {
        new UserApiApplictaion().run(args);
    }

    public void run(UserApiConfig userApiConfig, Environment environment) throws Exception {
        final UserApiResource resource = new UserApiResource();
        environment.jersey().register(resource);
        
        final UserHealthCheck healthCheck = new UserHealthCheck();
        environment.healthChecks().register("example", healthCheck);
    }
}