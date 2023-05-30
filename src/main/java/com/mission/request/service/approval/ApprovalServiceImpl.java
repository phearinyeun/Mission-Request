package com.mission.request.service.approval;

import com.mission.request.dto.ApprovalDto;
import com.mission.request.dto.RequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApprovalServiceImpl implements ApprovalService{
    @Override
    public ApprovalDto create(ApprovalDto approvalDto) {
        return null;
    }

    @Override
    public Page<ApprovalDto> getAllRequest(Pageable pageable) {
        return null;
    }

    @Override
    public RequestDto UpdateStatus(Long requestId, RequestDto requestDto) {
        return null;
    }

    @Override
    public Optional<ApprovalDto> findById(Long requestId) {
        return Optional.empty();
    }
}
