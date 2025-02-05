package com.twopiradrian.error;

public class ErrorResponse {

    public String message;

    public ErrorResponse(ErrorHandler errorHandler) {
        this.message = errorHandler.getMessage();
    }
}
