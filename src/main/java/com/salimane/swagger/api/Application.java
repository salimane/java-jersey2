package com.salimane.swagger.api;

import com.wordnik.swagger.jersey.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jersey.listing.JerseyApiDeclarationProvider;
import com.wordnik.swagger.jersey.listing.JerseyResourceListingProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

    public Application() {
        // Register resources and providers using package-scanning.
        // packages("com.salimane.swagger.api.resource");
        // packages("com.salimane.swagger.api.util");
        // packages("com.wordnik.swagger.jaxrs.listing");

        // Register my custom provider - not needed if it's in my.package.
        register(ApiListingResourceJSON.class).
                register(JerseyApiDeclarationProvider.class).
                register(JerseyResourceListingProvider.class);

        // register(SecurityRequestFilter.class);
        // Register an instance of LoggingFilter.
        // register(new LoggingFilter(LOGGER, true));

    }
}
