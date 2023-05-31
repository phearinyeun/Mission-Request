package com.mission.request.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mission.request.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "approvals")
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    @ManyToMany(mappedBy = "approval", fetch = FetchType.LAZY)
    private Set<Request> request;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date requestDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date responseDate;
    private Status status;
}
