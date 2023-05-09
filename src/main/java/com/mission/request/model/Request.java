package com.mission.request.model;

import com.mission.request.enums.Status;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Request {
    private String requestBy;
    private String requestTo;
    private LocalDate requestDate;
    private LocalDate startMissionDate;
    private String department;
    private String transportation;
    private Status status;
}
