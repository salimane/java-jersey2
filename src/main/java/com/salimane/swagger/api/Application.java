package com.salimane.swagger.api;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.wordnik.swagger.jersey.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jersey.listing.JerseyApiDeclarationProvider;
import com.wordnik.swagger.jersey.listing.JerseyResourceListingProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

    public Application() {
        // Register resources and providers using package-scanning.
        packages("com.salimane.swagger.api.resource");
        packages("com.salimane.swagger.api.util");
        packages("com.wordnik.swagger.jaxrs.listing");
        packages("com.fasterxml.jackson.jaxrs.json");

        // Register my custom provider - not needed if it's in my.package.
        register(ApiListingResourceJSON.class).
                register(JerseyApiDeclarationProvider.class).
                register(JerseyResourceListingProvider.class);
        register(JacksonJaxbJsonProvider.class);
        register(JacksonJsonProvider.class);

        // register(SecurityRequestFilter.class);
        // Register an instance of LoggingFilter.
        // register(new LoggingFilter(LOGGER, true));

    }
}
