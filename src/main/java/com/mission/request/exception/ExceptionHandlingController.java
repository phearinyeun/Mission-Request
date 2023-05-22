package com.mission.request.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleException (NotFoundException exception){
        NotFoundException requestNotFoundException = new NotFoundException();
        requestNotFoundException.setDateTime(LocalDateTime.now());
        requestNotFoundException.setMessage("Request not found");
        return new ResponseEntity<>(requestNotFoundException, HttpStatus.NOT_FOUND);
    }
}
