package com.okavango.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> notFound(ResourceNotFoundException exception, WebRequest request) {

        // instante atual com menos 3 horas
        Instant moment = Instant.now().minus(3, ChronoUnit.HOURS);
        String message = exception.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;

        APIError error = new APIError(moment,status,message);
        return ResponseEntity.status(error.getStatus()).body(error);
    }

}
