package com.mission.request.model;

import com.mission.request.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "requests")
@RequiredArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private String requestBy;
    private String role;
    private LocalDateTime requestDateTime;
    private String department;
    private String transportation;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "request_approval",
            joinColumns = @JoinColumn(name = "requests_id"),
            inverseJoinColumns = @JoinColumn(name = "approvals_id")
    )
    private Set<Approval> approval;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "request_members",
            joinColumns = @JoinColumn(name = "requests_id"),
            inverseJoinColumns = @JoinColumn(name = "members_id")
    )
    @ToString.Exclude
    private List<Members> members = new ArrayList<>();
    private String purpose;
    private LocalDate missionDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String comment;
    private String sbiAccountName;
    private String amount;
    private String sbiSavingAccount;
//    @Enumerated(EnumType.STRING)
    private Status status;

    public LocalDateTime getRequestDate() {
        return LocalDateTime.now();
    }
    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDateTime = LocalDateTime.now();
    }
}
