package com.mission.request.service.approval;

import com.mission.request.dto.ApprovalDto;
import com.mission.request.dto.RequestDto;
import com.mission.request.mapper.RequestMapper;
import com.mission.request.model.Request;
import com.mission.request.repository.ApprovalRepository;
import com.mission.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService{

    private final ApprovalRepository approvalRepository;
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    @Override
    public ApprovalDto create(ApprovalDto approvalDto) {
        return null;
    }

    @Override
    public Page<Request> getAllRequest(Pageable pageable) {
        Pageable paging = PageRequest.of(pageable.getPageSize(), pageable.getPageNumber());
        return requestRepository.findAll(paging);
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
