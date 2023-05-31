package com.mission.request.service.approval;

import com.mission.request.dto.ApprovalDto;
import com.mission.request.dto.RequestDto;
import com.mission.request.model.Request;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ApprovalService {
    ApprovalDto create(ApprovalDto approvalDto);
    Page<Request> getAllRequest(Pageable pageable);
    RequestDto UpdateStatus(Long requestId, RequestDto requestDto);
    Optional<ApprovalDto> findById(Long requestId);
}
