package com.mission.request.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponse {
    private int statusCode;
    private String error;
    private String message;
    private LocalDateTime dateTime;
}
