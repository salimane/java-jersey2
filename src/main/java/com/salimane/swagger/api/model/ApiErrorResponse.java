/**
 *
 *
 */

package com.salimane.swagger.api.model;

public class ApiErrorResponse {
    ApiResponse error;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(ApiResponse error) {
        this.error = error;
    }

    public ApiResponse getError() {
        return error;
    }

    public void setError(ApiResponse error) {
        this.error = error;
    }
}
