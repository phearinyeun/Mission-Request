package com.mission.request.service.request;

import com.mission.request.dto.RequestDto;
import com.mission.request.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RequestService {
    Request create(RequestDto request);
    Page<Request> getAllRequest(Pageable pageable);
    Optional<Request> findById(Long requestId);
    Optional<RequestDto> update(RequestDto request, Long requestId);
    Optional<RequestDto> deleteById(Long requestId);

}
