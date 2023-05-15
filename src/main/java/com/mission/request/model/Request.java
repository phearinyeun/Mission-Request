package com.mission.request.model;

import com.mission.request.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "requests")
@RequiredArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private String requestBy;
    private LocalDate requestDate;
    private String department;
    private String transportation;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "request_approval",
            joinColumns = @JoinColumn(name = "requests_id"),
            inverseJoinColumns = @JoinColumn(name = "approvals_id")
    )
    private Set<Approval> approvals = new HashSet<>();
    private List<String> members;
    private String purpose;
    private LocalDate missionDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String comment;
    private String sbiAccountName;
    private String amount;
    private String sbiSavingAccount;
    private Status status;

}
