package com.mission.request.exception;

import com.mission.request.exception.NotFound.RequestNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestNotFoundException.class)
    public ResponseEntity<Object> handleExceptions( RequestNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setStatusCode(404);
        response.setError("Not Found");
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Request Not Found");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SuccessException.class)
    public ResponseEntity<Object> successException(SuccessException exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse();
        response.setStatusCode(200);
        response.setMessage("Success");
        response.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(StatusException.class)
    public ResponseEntity<Object> status(StatusException exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse();
        response.setStatusCode(204);
        response.setMessage("You not able to update.");
        response.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
