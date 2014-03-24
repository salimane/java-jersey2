/**
 *
 *
 */

package com.salimane.swagger.api.resource;

import com.salimane.swagger.api.exception.ApiException;
import com.salimane.swagger.api.exception.BadRequestException;
import com.salimane.swagger.api.exception.NotFoundException;
import com.salimane.swagger.api.model.ApiErrorResponse;
import com.salimane.swagger.api.model.ApiResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<Exception> {
    public Response toResponse(Exception exception) {
        if (exception instanceof javax.ws.rs.WebApplicationException) {
            javax.ws.rs.WebApplicationException e = (javax.ws.rs.WebApplicationException) exception;
            return Response
                    .status(e.getResponse().getStatus())
                    .entity(new ApiErrorResponse(new ApiResponse(e.getResponse().getStatus(),
                            exception.getMessage()))).build();
        } else if (exception instanceof com.fasterxml.jackson.core.JsonParseException) {
            return Response.status(400)
                    .entity(new ApiErrorResponse(new ApiResponse(400, "bad input"))).build();
        } else if (exception instanceof NotFoundException) {
            return Response
                    .status(Status.NOT_FOUND)
                    .entity(new ApiErrorResponse(new ApiResponse(ApiResponse.ERROR, exception
                            .getMessage()))).build();
        } else if (exception instanceof BadRequestException) {
            return Response
                    .status(Status.BAD_REQUEST)
                    .entity(new ApiErrorResponse(new ApiResponse(ApiResponse.ERROR, exception
                            .getMessage()))).build();
        } else if (exception instanceof ApiException) {
            return Response
                    .status(Status.BAD_REQUEST)
                    .entity(new ApiErrorResponse(new ApiResponse(ApiResponse.ERROR, exception
                            .getMessage()))).build();
        } else {
            return Response.status(500)
                    .entity(new ApiErrorResponse(new ApiResponse(500, "something bad happened")))
                    .build();
        }
    }
}
