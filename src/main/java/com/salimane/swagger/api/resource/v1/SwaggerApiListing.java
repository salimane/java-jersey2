package com.salimane.swagger.api.resource.v1;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * swagger configuration class to generate swagger JSON file for swagger-ui
 *
 * @author Salimane Adjao Moustapha <me@salimane.com>
 */
@Path("/v1/api-docs")
@Api("/v1/api-docs")
@Produces({"application/json"})
public class SwaggerApiListing extends ApiListingResourceJSON {
}
