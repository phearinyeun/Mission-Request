package com.mission.request.service.request;

import com.mission.request.dto.RequestDto;
import com.mission.request.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    Request create(RequestDto request);
//    Page<RequestDto> getAllRequest(Pageable pageable);
//    Optional<RequestDto> findById(Long requestId);
//    List<RequestDto> update(RequestDto request, Long requestId);
//    Optional<RequestDto> deleteById(Long requestId);

}
