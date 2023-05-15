package com.mission.request.model;

import com.mission.request.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "approvals")
@RequiredArgsConstructor
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "approvals")
    private Set<Request> requests = new HashSet<>();
    private String requestDate;
    private String approvedDate;
    private Status status;
}
