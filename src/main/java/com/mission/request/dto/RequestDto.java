package com.mission.request.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mission.request.enums.Status;
import com.mission.request.model.Approval;
import com.mission.request.model.Members;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RequestDto {
    private Long requestId;
    private String requestUsername;
    private LocalDateTime requestDateTime;
    private String department;
    private String transportation;
    private Set<Approval> approval;
    private List<Members> teamMembers;
    private String purpose;
    private LocalDate missionDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date missionStartDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date missionEndDate;
    private String comment;
    private String sbiAccountName;
    private int amount;
    private int sbiSavingAccount;
    private Status status;
    public void setRequestDateTime(LocalDateTime requestDateTime) {
        this.requestDateTime = LocalDateTime.now();
    }
}
