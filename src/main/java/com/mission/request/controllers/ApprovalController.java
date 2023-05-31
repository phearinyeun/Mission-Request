package com.mission.request.controllers;


import com.mission.request.model.Request;
import com.mission.request.service.approval.ApprovalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalServiceImpl approvalService;

    @GetMapping
    public Page<Request> getAllRequest(Pageable pageable){
        return approvalService.getAllRequest(pageable);
    }
}
