package com.mission.request.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mission.request.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ApprovalDto {
    private Long approvalId;
    private String approvalUsername;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date requesterDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date approvalResponseDate;
    private Status status;
}
